package org.java.stepfiles;

import io.cucumber.core.internal.com.fasterxml.jackson.databind.node.ArrayNode;
import io.cucumber.java.en.*;
import org.java.core.executor;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Objects;

public class GeneralSteps {
    String endpoint, payload, method;
    Object response;
    @Given("EndPoint is {string}")
    public void endpointIs(String arg0) {
        endpoint = arg0;

    }

    @And("Method is {string}")
    public void methodIs(String arg0) {
        method = arg0;

    }

    @When("Bot executes")
    public void botExecutes() {
        response = executor.getRequest(endpoint, method);
    }

    @Then("{string} should not be {string}")
    public void shouldNotBe(String arg0, String arg1) {
        for (int i=0; i<10;i++) {
            if (arg1 == "null") {
                if (Objects.equals(((ArrayNode) response).get(i).get(arg0).textValue(), null) || Objects.equals(((ArrayNode) response).get(i).get(arg0).textValue(), "")) {
                    Assert.fail("id is null");
                }
            } else {
                if (Objects.equals(((ArrayNode) response).get(i).get(arg0).textValue(), arg1)) {
                    Assert.fail("id is null");
                }
            }
        }
    }


    @And("Payload is {string}")
    public void payloadIs(String arg0) {
        
    }


    @And("print lowest in cost")
    public void printLowestInCost() {
        int lowest = 0;
        for (int i=0; i<10;i++){
            int price;
            if (((ArrayNode) response).get(i).get("data").has("price")) {
                price = ((ArrayNode) response).get(i).get("data").get("price").intValue();
                if (price < lowest || lowest == 0) {
                    lowest = price;
                }
            }
        }
        System.out.println(lowest);
    }

    @And("print mobile starting with apple")
    public ArrayList<String> printMobileStartingWithApple() {
        ArrayList<String> apple = new ArrayList<>();
        for (int i=0; i<10;i++){
            if(((ArrayNode) response).get(i).has("name")) {
                String name = ((ArrayNode) response).get(i).get("name").textValue();
                if (name.startsWith("Apple")){
                    apple.add(name);
                }
            }
        }
        System.out.println(apple);
        return apple;
    }
}