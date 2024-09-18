package be.hanagami.whatsappclone.messaging.domain.message.aggregate;

import be.hanagami.whatsappclone.shared.error.domain.Assert;

import java.util.List;

public record Messages(List<Messages> messages) {

    public Messages {
        Assert.field("messages", messages).notNull().noNullElement();
    }
}
