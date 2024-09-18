package be.hanagami.whatsappclone.messaging.domain.user.vo;

import be.hanagami.whatsappclone.shared.error.domain.Assert;

public record UserFirstName(String value) {

    public UserFirstName {
        Assert.field(value, value).maxLength(255);
    }
}
