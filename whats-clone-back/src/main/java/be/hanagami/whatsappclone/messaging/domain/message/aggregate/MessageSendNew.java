package be.hanagami.whatsappclone.messaging.domain.message.aggregate;

import be.hanagami.whatsappclone.messaging.domain.message.vo.ConversationPublicId;
import be.hanagami.whatsappclone.messaging.domain.message.vo.MessageContent;

public record MessageSendNew(MessageContent messageContent,
                             ConversationPublicId conversationPublicId) {


}
