package com.acalendar.acal.Messages;

/**
 * Request object used to create a message
 * 
 * */
public class CreateMessageRequest {

    /**
     * Category of the message.
     * */
    private MessageCategory messageCategory;

    /**
     * The id of the event that is associated with this message.
     * */
    private int eventId;

    /////////////////////////////////////////////////////////////////////
    //////                  Getters and setters                     /////
    /////////////////////////////////////////////////////////////////////

    /**
     * Return the message category of this CreateMessageRequest
     *
     * @return the message category of this CreateMessageRequest
     * */
    public MessageCategory getMessageCategory() {
        return this.messageCategory;
    }

    /**
     * Set the message category of this CreateMessageRequest
     *
     * @param messageCategory
     * */
    public void setMessageCategory(MessageCategory messageCategory) {
        this.messageCategory = messageCategory;
    }

    /**
     * Get the event id
     *
     * @return event id
     * */
    public int getEventId() {
        return this.eventId;
    }

    /**
     * Set the event id
     *
     * @param eventId
     * */
    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

}


