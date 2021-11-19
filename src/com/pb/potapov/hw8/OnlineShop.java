package com.pb.potapov.hw8;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.sql.SQLOutput;
import java.util.Scanner;

public class OnlineShop {

    public static class Auth {
        private String login;
        private String password;

        public String getLogin() {
            return login;
        }

        public void setLogin(String login) {
            this.login = login;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public void signUp(String login, String password, String confirmPassword) throws WrongLoginException, WrongPasswordException {

            String rexp = "^[a-zA-Z0-9]+$";
            if (!((login.length() > 4) && (login.length() < 21) && login.matches(rexp))) {
                throw new WrongLoginException("Ошибка регистрации. Неверно задан логин.");
            }

            rexp = "^[a-zA-Z0-9_]+$";
            if (!((password.length() > 4) && password.matches(rexp) && password.equals(confirmPassword))) {
                throw new WrongPasswordException("Ошибка регистрации. Неверно задан пароль.");
            }

            setLogin(login);
            setPassword(password);
            System.out.println("Поздравляем - регистрация успешна.");
        }

        public void signIn(String login, String password) throws WrongLoginException, WrongPasswordException {
            if (!login.equals(getLogin())) {
                throw new WrongLoginException("Ошибка ввода. Неверно задан логин.");

            }
            if (!password.equals(getPassword())) {
                throw new WrongPasswordException("Ошибка ввода. Неверно задан пароль.");

            }
            System.out.println("Вход в систему выполнен успешно.");

        }
    }

    public static void main(String[] args) {
        String inLogin;
        String inPass;
        String inPassComf;
        boolean isSuccess = false;
        int counter = 0;
        final byte LIMIT_OF_ATTEMPTS = 3;

        Auth userShop = new Auth();

        Scanner scan = new Scanner(System.in);

        System.out.println("Добро пожаловать в наш on-line магазин.\nЧтобы совершить покупку, Вам нужно зарегистрироваться.");


        do {
            counter++;
            if (counter>1){
                System.out.println("\nПовторите попытку регистрации!");
            }
            System.out.println("\nПридумайте логин для входа в систему. Латинские буквы и цифры. Длинна от 5 до 20 символов.\n\n");
            System.out.print("Логин ->");
            inLogin = scan.next();
            System.out.println("\nПридумайте пароль. Длинна более 5 символов, только латинские буквы и цифры и знак подчеркивания.");
            System.out.print("Пароль ->");
            inPass = scan.next();
            System.out.print("Подтвердите пароль ->");
            inPassComf = scan.next();
            try {
                userShop.signUp(inLogin, inPass, inPassComf);
                isSuccess = true;           // успешная регистрация
                break;

            } catch (WrongLoginException ex) {
                System.out.println("login error: " + ex.getMessage());

            } catch (WrongPasswordException ex) {
                System.out.println("password error: " + ex.getMessage());

            }

        } while (counter < LIMIT_OF_ATTEMPTS);
        if (!isSuccess) {
            System.out.println("Вы превысили число попыток регистрации.\nПопробуйте в следующий раз.");
            return;               // завершаем сеанс работы с пользователем
        }

        isSuccess = false;
        counter = 0;
        do {
            counter++;
            if (counter>1){
                System.out.println("\nПовторите попытку регистрации!");
            }
            System.out.println("\nДля входа в наш on-line магазин введите свои данные.");
            System.out.print("Логин ->");
            inLogin = scan.next();
            System.out.print("Пароль ->");
            inPass = scan.next();
            try {
                userShop.signIn(inLogin, inPass);
                isSuccess = true;             // пользователь успешно залогинился
                break;
            } catch (WrongLoginException ex) {
                System.out.println("login error: " + ex.getMessage());

            } catch (WrongPasswordException ex) {
                System.out.println("password error: " + ex.getMessage());

            }

        } while (counter < LIMIT_OF_ATTEMPTS);
        if (!isSuccess) {
            System.out.println("Вы превысили число попыток входа.\nЛогин заблокирован.");
        }
        // завершение программы

    }
}
