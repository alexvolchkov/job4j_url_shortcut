package ru.job4j.shortcut.domain;

public class RegDao {
    private boolean reg;
    private String login;
    private String password;

    public static RegDao of(boolean reg, String login, String password) {
        RegDao regDao = new RegDao();
        regDao.reg = reg;
        regDao.login = login;
        regDao.password = password;
        return regDao;
    }

    public static RegDao of(boolean reg, String login) {
        RegDao regDao = new RegDao();
        regDao.reg = reg;
        regDao.login = login;
        regDao.password = "";
        return regDao;
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
