package be.hanagami.whatsappclone.messaging.domain.user.aggregate;

import be.hanagami.whatsappclone.messaging.domain.user.vo.AuthorityName;
import be.hanagami.whatsappclone.shared.error.domain.Assert;
import org.jilt.Builder;

@Builder
public class Authority {

    private AuthorityName name;

    public Authority(AuthorityName name) {
        Assert.notNull("name", name);
        this.name = name;
    }

    public AuthorityName getName() {
        return name;
    }
}
