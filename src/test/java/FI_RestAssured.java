import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FI_RestAssured {

    @Test
    public void testFI1() {

        // Using Supplier Interface for Request Customization:
        Supplier<RequestSpecification> requestSpecSupplier = () ->
                RestAssured.given()
                        .baseUri("https://jsonplaceholder.typicode.com")
                        .contentType("application/json");

        // Using Consumer Interface for Response logging:
        Consumer<Response> handleResponse = response -> {
            System.out.println("Response Status Code: " + response.getStatusCode());
            System.out.println("Response Body: " + response.getBody().asString());
            // You can add more handling logic here
        };

        // Using Function Interface for some transformation
        Function<List<String>, List<String>> toUpperCase = list -> {
            for (int i = 0; i < list.size(); i++) {
                list.set(i, list.get(i).toUpperCase());
            }
            return list;
        };

        // Using Preidcate Interface for assertion
        Predicate<Response> checkUserResponse = response -> {
            List<Integer> ids = response.jsonPath().getList("id");
            List<String> usernames = response.jsonPath().getList("username");
            return ids.stream().allMatch(id -> id < 10)
                    &&
                    usernames.stream().noneMatch(un -> un.contains(" "));
        };

        // invoke the supplier get method the request specification
        RequestSpecification requestSpec = requestSpecSupplier.get();
        Response response = requestSpec.get("/users");

        // invoke consumer accept method to log the response content and code
        handleResponse.accept(response);

        List<String> originalNames = response.jsonPath().getList("name");
        // invoke Function interface for the transformation using applly method
        List<String> uppercaseNames = toUpperCase.apply(originalNames);
        System.out.println("Names in Upper case " + uppercaseNames);

        // invoke predicate interface for assertion using test method
        Assert.assertTrue(checkUserResponse.test(response), "Atleast one of the id or Username is not as expected");
    }
}
