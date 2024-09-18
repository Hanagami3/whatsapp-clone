package be.hanagami.whatsappclone.messaging.domain.user.vo;

import be.hanagami.whatsappclone.shared.error.domain.Assert;

public record UserLastName(String value) {

    public UserLastName {
        Assert.field(value, value).maxLength(255);
    }
}
