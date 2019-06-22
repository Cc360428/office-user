package com.office.user.entity;

import java.util.Objects;

/**
 * @author Hyper-Li
 * @title: EmailUtil
 * @projectName office-user
 * @description: TODO
 * @date 2019.06.22.002215:43
 */
public class EmailUtil {
    //发送邮箱
    private String meail;

    @Override
    public String toString() {
        return "EmailUtil{" +
                "meail='" + meail + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmailUtil emailUtil = (EmailUtil) o;
        return Objects.equals(meail, emailUtil.meail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(meail);
    }

    public String getMeail() {
        return meail;
    }

    public void setMeail(String meail) {
        this.meail = meail;
    }
}
