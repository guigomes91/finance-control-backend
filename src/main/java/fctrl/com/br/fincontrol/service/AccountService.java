import java.util.List;
import java.util.UUID;

import fctrl.com.br.fincontrol.model.Account;

public interface AccountService {
    
    Account update(Account acc, UUID id);

    List<Account> list();

    Account listById(UUID id);

    Account save(Account acc);

    void delete(UUID id);
}
