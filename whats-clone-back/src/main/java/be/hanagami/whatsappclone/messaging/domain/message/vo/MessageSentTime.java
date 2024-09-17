package be.hanagami.whatsappclone.messaging.domain.message.vo;


import be.hanagami.whatsappclone.shared.error.domain.Assert;

import java.time.Instant;

public record MessageSentTime(Instant date) {

    public MessageSentTime {
        Assert.field("date", date).notNull();
    }
}
