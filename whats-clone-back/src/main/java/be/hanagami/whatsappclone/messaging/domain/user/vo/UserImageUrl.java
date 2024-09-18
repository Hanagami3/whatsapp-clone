package be.hanagami.whatsappclone.messaging.domain.user.vo;

import be.hanagami.whatsappclone.shared.error.domain.Assert;

public record UserImageUrl(String value) {

    public UserImageUrl {
        Assert.field(value, value).maxLength(255);
    }
}
