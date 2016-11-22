package lambda;

import com.amazonaws.services.lambda.runtime.Context;
import model.Event;
import model.EventSharingService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by rettymoo on 28/10/2016.
 */
public class EventSharingHandler {

    /**
     * Edit attendees of an Event.
     * @param input "eventId" => String: id of event concerning
     *              "userId" => String: id of user requesting this action
     *              "invited" => List<String>: list of userIds to be invited into this event
     *              "removed" => List<String>: list of userIds to be reomved from this event
     * @param context
     * @return map containing one KVPair: "attendees" => list of userIds within in this event after editing, both pending and accepted
     */
    public Map<String, List<String>> editAttendees(Map<String, Object> input, Context context) {
        if (input == null) {
            throw new IllegalArgumentException();
        }
        String eventId = (String) input.get("eventId");
        String userId = (String) input.get("userId");
        List<String> removed = (List<String>) input.get("removed");
        List<String> invited = (List<String>) input.get("invited");

        Map<String, List<String>> res = new HashMap<>();
        res.put("attendees", EventSharingService.editEventAttendees(eventId, userId, invited, removed));
        return res;
    }

    /**
     * Accept invitation into an event.
     * @param input "userId" => String: id of user accepting invitation
     *              "eventId" => String: id of event under concern
     * @param context
     * @return map containing one KVPair: "res" => true if this action succeed, false otherwise
     */
    public Map<String, Boolean> acceptEventInvitation(Map<String, String> input, Context context) {
        if (input == null) {
            throw new IllegalArgumentException();
        }
        String userId = input.get("userId");
        String eventId = input.get("eventId");

        Map<String, Boolean> result = new HashMap<>();
        result.put("res", EventSharingService.handleEventInvitation(userId, eventId, true));
        return result;
    }

    /**
     * Decline invitation into an event.
     * @param input "userId" => String: id of user declining invitation
     *              "eventId" => String: id of event under concern
     * @param context
     * @return map containing one KVPair: "res" => true if this action succeed, false otherwise
     */
    public Map<String, Boolean> declineEventInvitation(Map<String, String> input, Context context) {
        if (input == null) {
            throw new IllegalArgumentException();
        }
        String userId = input.get("userId");
        String eventId = input.get("eventId");

        Map<String, Boolean> result = new HashMap<>();
        result.put("res", EventSharingService.handleEventInvitation(userId, eventId, false));
        return result;
    }

    /**
     * Get all events that are pending under a userId.
     * @param input "userId" => String: id of user requesting eventIds
     * @param context
     * @return Map containing one KVPair: "events" => list of all matching events, each event's information is stored in a map
     */
    public Map<String, Object> getPendingEventsByUserId(Map<String, String> input, Context context) {
        if (input == null) {
            throw new IllegalArgumentException();
        }
        String userId = input.get("userId");
        return Event.getEventsByUserId(userId, "PENDING");
    }
}
