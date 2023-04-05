import java.util.UUID;

import fctrl.com.br.fincontrol.model.Account;

public interface AccountService {
    
    Account update(Account acc, UUID id);
}
