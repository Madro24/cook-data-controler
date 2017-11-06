package com.madro.cook;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.madro.cook.data.dynamodb.repositories.RecipeRepository;
import com.madro.cook.models.Recipe;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = CookDataControllerApplication.class)
@WebAppConfiguration
@ActiveProfiles("local")
@TestPropertySource(properties = { 
  "amazon.dynamodb.endpoint=http://localhost:8000/", 
  "amazon.aws.accesskey=test1", 
  "amazon.aws.secretkey=test231" })
public class RecipeInfoRepositoryIntegrationTest {
 
   // private DynamoDBMapper dynamoDBMapper;
 
   // @Autowired
   // private AmazonDynamoDB amazonDynamoDB;
 
    @Autowired
    RecipeRepository repository;
 
    private static final String EXPECTED_NAME = "Burrito";
    private static final String EXPECTED_TYPE = "Desayuno";
 
    @Before
    public void setup() throws Exception {
   /*     dynamoDBMapper = new DynamoDBMapper(amazonDynamoDB);
         
        CreateTableRequest tableRequest = dynamoDBMapper
          .generateCreateTableRequest(Recipe.class);
        tableRequest.setProvisionedThroughput(
          new ProvisionedThroughput(1L, 1L));
        amazonDynamoDB.createTable(tableRequest);
         
        //...
 
        dynamoDBMapper.batchDelete(
          (List<Recipe>)repository.findAll());*/
    }
 
    @Test
    public void sampleTestCase() {
        Recipe dave = new Recipe(EXPECTED_NAME, EXPECTED_TYPE);
        repository.save(dave);
 
        List<Recipe> result 
          = (List<Recipe>) repository.findAll();
         
        assertTrue("Not empty", result.size() > 0);
        assertTrue("Contains item with expected cost", 
          result.get(0).getName().equals(EXPECTED_NAME));
    }
}
