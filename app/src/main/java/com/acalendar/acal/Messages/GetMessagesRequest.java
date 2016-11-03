package com.acalendar.acal.Messages;

/**
 * Reqeust object used when retrieving objects from db
 *
 */
public class GetMessagesRequest {

    /**
     * The id of the event whose messages we want to retrieve
     * */
    private int eventId;

    /**
     * Offset in the db; used to facilitate pagination
     * */
    private int offset;

    /**
     * How many messages to retrieve
     * */
    private int howMany;

    /////////////////////////////////////////////////////////////////
    /////                getters and setters                   //////
    /////////////////////////////////////////////////////////////////

    public int getEventId() {
        return this.eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public int getOffset() {
        return this.offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getHowMany() {
        return this.howMany;
    }

    public void setHowMany(int howMany) {
        this.howMany = howMany;
    }

}
