package be.hanagami.whatsappclone.messaging.domain.user.vo;

import be.hanagami.whatsappclone.shared.error.domain.Assert;

public record AuthorityName(String name) {

    public AuthorityName {
        Assert.field("name", name).notNull();
    }
}
