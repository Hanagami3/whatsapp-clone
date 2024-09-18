package be.hanagami.whatsappclone.messaging.domain.message.aggregate;


import be.hanagami.whatsappclone.shared.error.domain.Assert;

import java.util.List;

public record Conversations(List<Conversation> conversations) {

    public Conversations {
        Assert.field("conversations", conversations).notNull().noNullElement();
    }
}
