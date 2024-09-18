package be.hanagami.whatsappclone.messaging.domain.repository;

import be.hanagami.whatsappclone.messaging.domain.message.aggregate.Conversation;
import be.hanagami.whatsappclone.messaging.domain.message.aggregate.Conversations;
import be.hanagami.whatsappclone.messaging.domain.message.aggregate.Message;
import be.hanagami.whatsappclone.messaging.domain.message.vo.ConversationPublicId;
import be.hanagami.whatsappclone.messaging.domain.message.vo.MessageSendState;
import be.hanagami.whatsappclone.messaging.domain.user.aggregate.User;
import be.hanagami.whatsappclone.messaging.domain.user.vo.UserPublicId;

import java.util.List;

public interface MessageRepository {

    Message save(Message message, User sender, Conversation conversation);

    int updateMessageSendState(ConversationPublicId conversationPublicId, UserPublicId userPublicId, MessageSendState messageSendState);

    List<Message> findMessageToUpdateSendState(ConversationPublicId conversationPublicId, UserPublicId userPublicId);
}
