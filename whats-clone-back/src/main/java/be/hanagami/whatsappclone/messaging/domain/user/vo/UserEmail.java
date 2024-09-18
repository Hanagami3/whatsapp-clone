package be.hanagami.whatsappclone.messaging.domain.user.vo;

import be.hanagami.whatsappclone.shared.error.domain.Assert;

public record UserEmail(String value) {

    public UserEmail{
        Assert.field(value, value).maxLength(255);
    }
}
