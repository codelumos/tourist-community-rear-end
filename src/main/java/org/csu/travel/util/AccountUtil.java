package org.csu.travel.util;

import org.csu.travel.core.AccountUp;
import org.csu.travel.domain.Account;
import org.csu.travel.domain.AccountInfo;

import java.util.ArrayList;
import java.util.List;

public class AccountUtil {

    public static void downAccountUp(AccountUp accountUp, Account account, AccountInfo accountInfo) {
        account.setUserId(accountUp.getUserId());
        account.setPassword(accountUp.getPassword());

        accountInfo.setDescription(accountUp.getDescription());
        accountInfo.setUserName(accountUp.getUserName());
        accountInfo.setUserId(accountUp.getUserId());
        accountInfo.setBirthday(accountUp.getBirthday());
        accountInfo.setImagePath(accountUp.getImagePath());
        accountInfo.setSex(accountUp.getSex());
        accountInfo.setTag1(accountUp.getTag1());
        accountInfo.setTag2(accountUp.getTag2());
        accountInfo.setTag3(accountUp.getTag3());
        String homelp = "";
        String livelp = "";
        if (accountUp.getHome() != null && accountUp.getHome().size() != 0)
            homelp = accountUp.getHome().toString();
        if (accountUp.getLive() != null && accountUp.getLive().size() != 0)
            livelp = accountUp.getLive().toString();

        if (!homelp.equals(""))
            accountInfo.setHomelp(homelp);
        if (!livelp.equals(""))
            accountInfo.setLivelp(livelp);
    }

    public static void upAccountUp(AccountUp accountUp, Account account, AccountInfo accountInfo) {
        accountUp.setUserId(account.getUserId() == null ? "" : account.getUserId());
        accountUp.setPassword(account.getPassword() == null ? "" : account.getPassword());
        accountUp.setUserName(accountInfo.getUserName() == null ? "" : accountInfo.getUserName());
        accountUp.setBirthday(accountInfo.getBirthday());
        accountUp.setDescription(accountInfo.getDescription() == null ? "" : accountInfo.getDescription());
        accountUp.setImagePath(accountInfo.getImagePath() == null ? "" : accountInfo.getImagePath());
        accountUp.setSex(accountInfo.getSex() == null ? "" : accountInfo.getSex());
        accountUp.setTag1(accountInfo.getTag1() == null ? "" : accountInfo.getTag1());
        accountUp.setTag2(accountInfo.getTag2() == null ? "" : accountInfo.getTag2());
        accountUp.setTag3(accountInfo.getTag3() == null ? "" : accountInfo.getTag3());

        List<Integer> home = new ArrayList<>();
        List<Integer> live = new ArrayList<>();

        String homelp = accountInfo.getHomelp();
        String[] homelps = null;
        if (homelp != null && homelp.length() != 2) {
            homelps = homelp.substring(1, homelp.length() - 1).split(", ");
            for (String s :
                    homelps) {
                home.add(Integer.parseInt(s));
            }
        }

        String livelp = accountInfo.getLivelp();
        String[] livelps;
        if (livelp != null && livelp.length() != 2) {
            livelps = livelp.substring(1, livelp.length() - 1).split(", ");
            for (String s :
                    livelps) {
                live.add(Integer.parseInt(s));
            }
        }

        accountUp.setLive(live);
        accountUp.setHome(home);
    }

}
