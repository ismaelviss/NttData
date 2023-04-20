package com.ismaelviss.nttdata.adapter.out.persistence.adapter;

import com.ismaelviss.nttdata.adapter.out.persistence.mapper.AccountMapper;
import com.ismaelviss.nttdata.adapter.out.persistence.repository.AccountRepository;
import com.ismaelviss.nttdata.adapter.out.persistence.repository.ClientRepository;
import com.ismaelviss.nttdata.application.port.out.AccountPort;
import com.ismaelviss.nttdata.common.PersistenceAdapter;
import com.ismaelviss.nttdata.common.exception.ApplicationException;
import com.ismaelviss.nttdata.domain.Account;

import java.util.List;

@PersistenceAdapter
public class AccountPersistenceAdapter implements AccountPort {

    private final AccountRepository accountRepository;
    private final ClientRepository clientRepository;

    public AccountPersistenceAdapter(AccountRepository accountRepository, ClientRepository clientRepository) {
        this.accountRepository = accountRepository;
        this.clientRepository = clientRepository;
    }

    @Override
    public Account get(String id) throws ApplicationException {
        return accountRepository
                .findById(id)
                .map(AccountMapper.INSTANCE::toAccount)
                .orElseThrow(() -> new ApplicationException("NOT_FOUND_ACCOUNT","cuenta no existe"));
    }

    @Override
    public List<Account> getAll() {
        return accountRepository
                .findAll()
                .stream()
                .map(AccountMapper.INSTANCE::toAccount)
                .toList();
    }

    @Override
    public void update(Account account) throws ApplicationException {
        var accountEntityOptional = accountRepository.findById(account.getAccountNumber());
        if (accountEntityOptional.isPresent()) {
            var accountEntity = accountEntityOptional.get();
            accountEntity.setAccountType(account.getAccountType());
            accountEntity.setInitialBalance(account.getInitialBalance());
            accountEntity.setState(account.getState());
            accountRepository.save(accountEntity);
        }
        else {
            throw new ApplicationException("NOT_FOUND_ACCOUNT", "cuenta no existe");
        }
    }

    @Override
    public void delete(String id) throws ApplicationException {
        var accountEntityOptional = accountRepository.findById(id);
        if (accountEntityOptional.isPresent()) {
            accountRepository.delete(accountEntityOptional.get());
        }
        else {
            throw new ApplicationException("NOT_FOUND_ACCOUNT", "cuenta no existe");
        }
    }

    @Override
    public Account add(Account account) throws ApplicationException {
        return AccountMapper.INSTANCE.toAccount(accountRepository.save(AccountMapper.INSTANCE.toAccountEntity(account)));
    }
}
