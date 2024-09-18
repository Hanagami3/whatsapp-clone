package be.hanagami.whatsappclone.messaging.domain.message.aggregate;

import be.hanagami.whatsappclone.messaging.domain.message.vo.*;
import be.hanagami.whatsappclone.messaging.domain.user.vo.UserPublicId;
import org.jilt.Builder;
import be.hanagami.whatsappclone.shared.error.domain.Assert;

@Builder
public class Message {

    private final MessageSentTime sentTime;

    private final MessageContent content;

    private final MessageSendState sendState;

    private final MessagePublicId publicId;

    private final UserPublicId sender;

    private final ConversationPublicId conversationPublicId;

    public Message(MessageSentTime sentTime, MessageContent content,
                   MessageSendState sendState, MessagePublicId publicId,
                   UserPublicId sender, ConversationPublicId conversationId) {
        assertMandatoryFields(sentTime, content, sendState, publicId, sender, conversationId);
        this.sentTime = sentTime;
        this.content = content;
        this.sendState = sendState;
        this.publicId = publicId;
        this.sender = sender;
        this.conversationPublicId = conversationId;
    }

    private void assertMandatoryFields(MessageSentTime sentTime,
                                       MessageContent content,
                                       MessageSendState state,
                                       MessagePublicId publicId,
                                       UserPublicId sender,
                                       ConversationPublicId conversationId){
        Assert.notNull("sentTime", sentTime);
        Assert.notNull("content", content);
        Assert.notNull("state", state);
        Assert.notNull("publicId", publicId);
        Assert.notNull("sender", sender);
        Assert.notNull("conversationId", conversationId);
    }

    public MessageSentTime getSentTime() {
        return sentTime;
    }

    public MessageContent getContent() {
        return content;
    }

    public MessageSendState getSendState() {
        return sendState;
    }

    public MessagePublicId getPublicId() {
        return publicId;
    }

    public UserPublicId getSender() {
        return sender;
    }

    public ConversationPublicId getConversationPublicId() {
        return conversationPublicId;
    }
}
