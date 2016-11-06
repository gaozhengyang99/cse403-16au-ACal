package lambda;

import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.spec.PutItemSpec;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.PutItemRequest;
import com.amazonaws.services.lambda.runtime.Context;

import model.CreateMessageRequest;
import model.CreateMessageResponse;
import model.GetMessagesRequest;
import model.GetMessagesResponse;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class MessageHandler {

    public CreateMessageResponse createMessage(CreateMessageRequest request, Context context) {
        AmazonDynamoDBClient client = new AmazonDynamoDBClient().withEndpoint("https://dynamodb.us-west-2.amazonaws.com");
        DynamoDB dynamoDB = new DynamoDB(client);
        Table table = dynamoDB.getTable("acalendar-mobilehub-1275254137-messages");

        PutItemSpec putItemSpec = new PutItemSpec();
        Item item = new Item();
        UUID randomUUID = UUID.randomUUID();
        item.with("id", randomUUID.toString());
        Date currTime = new Date();
        item.with("createdAt", currTime.getTime());
        item.with("createdBy", request.getUserId());
        item.with("eventId", request.getEventId());
        item.with("messageCategory", request.getMessageCategory());
        putItemSpec.withItem(item);
        table.putItem(putItemSpec);

        CreateMessageResponse response = new CreateMessageResponse();
        response.setMessageId(randomUUID.toString());
        return response;
    }

    public GetMessagesResponse getMessages(GetMessagesRequest request, Context context) {

        return null;
    }

    /**
     * Keep this main here for easy testing.
     * Remove before shipping.
     *
     * @param args
     */
    public static void main(String[] args) {

    }

}
