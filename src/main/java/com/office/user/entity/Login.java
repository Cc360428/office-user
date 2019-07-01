package com.office.user.entity;

import java.util.Objects;

/**
 * @author Hyper-Li
 * @title: Login
 * @projectName office-user
 * @description:
 * @date 2019.06.18.001810:01
 */
public class Login {
    private String account;
    private String password;
    private String confirmPassword;

    @Override
    public String toString() {
        return "Login{" +
                "account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", confirmPassword='" + confirmPassword + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Login login = (Login) o;
        return account.equals(login.account) &&
                password.equals(login.password) &&
                confirmPassword.equals(login.confirmPassword);
    }

    @Override
    public int hashCode() {
        return Objects.hash(account, password, confirmPassword);
    }

    public String getPassword() {

        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }
}
