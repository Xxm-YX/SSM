package cn.itcast.service;

import cn.itcast.domain.Account;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface AccountService {

    public List<Account> findAll();

    public void saveAccount(Account account);

    public void unZip(MultipartFile zipfile);
}
