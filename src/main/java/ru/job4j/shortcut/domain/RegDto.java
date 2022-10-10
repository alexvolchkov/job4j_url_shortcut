package ru.job4j.shortcut.domain;

public class RegDto {
    private boolean reg;
    private String login;
    private String password;

    public static RegDto of(boolean reg, String login, String password) {
        RegDto regDTO = new RegDto();
        regDTO.reg = reg;
        regDTO.login = login;
        regDTO.password = password;
        return regDTO;
    }

    public static RegDto of(boolean reg, String login) {
        RegDto regDTO = new RegDto();
        regDTO.reg = reg;
        regDTO.login = login;
        regDTO.password = "";
        return regDTO;
    }

    public boolean isReg() {
        return reg;
    }

    public void setReg(boolean reg) {
        this.reg = reg;
    }

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
}
