import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CodilityTest extends Base{


    WebElement searchInput = driver.findElement(By.id("search-input"));
    WebElement searchButton = driver.findElement(By.id("search-button"));
    WebElement errorEmptyQuery;
    WebElement errorNoResult;
    WebElement oneResult;
    List<WebElement> webElementList;

    String noResultQueryError;
    String emptyQueryError;

    public static final String PROVIDE_SOME_QUERY = "Provide some query";
    public static final String NO_RESULT_QUERY = "No results";
    public static final String ISLA_QUERY = "isla";
    public static final String CASTLE_QUERY = "castle";
    public static final String PORT_ROYAL_QUERY = "Port Royal";


    public CodilityTest() { }

    @Test
    public void verifyElements(){
        Assert.assertTrue(searchInput.isDisplayed());
        Assert.assertTrue(searchButton.isEnabled());
    }

    @Test
    public void verifyEmptyQuery(){
        searchInput.sendKeys( "" );
        searchButton.click();
        errorEmptyQuery = driver.findElement(By.id( "error-empty-query" ));
        emptyQueryError = errorEmptyQuery.getText();
        Assert.assertEquals( emptyQueryError, PROVIDE_SOME_QUERY );
  }

  @Test
    public void verifyNoResultQuery(){
      searchInput.sendKeys(CASTLE_QUERY);
      searchButton.click();
      errorNoResult = driver.findElement(By.id( "error-no-results" ));
      noResultQueryError = errorNoResult.getText();
      Assert.assertEquals(noResultQueryError, NO_RESULT_QUERY);
      searchInput.clear();
  }

  @Test
    public void verifyListNotEmpty(){
      searchInput.sendKeys(ISLA_QUERY);
      searchButton.click();
      webElementList = driver.findElements(By.xpath( "//ul[@id = 'search-results']"));
      Assert.assertTrue( !webElementList.isEmpty() );
      searchInput.clear();
  }

  @Test
    public void verifyOneResult(){
      searchInput.sendKeys( PORT_ROYAL_QUERY);
      searchButton.click();
      webElementList = driver.findElements(By.xpath("//ul[@id = 'search-results']/li"));
      Assert.assertTrue( webElementList.size() == 1 );
      oneResult = webElementList.get(0);
      Assert.assertEquals(oneResult.getText(),PORT_ROYAL_QUERY);
      searchInput.clear();
  }

    @Test
    public void verifyCaseInsensitive(){
        searchInput.sendKeys( PORT_ROYAL_QUERY.toLowerCase());
        searchButton.click();
        webElementList = driver.findElements(By.xpath("//ul[@id = 'search-results']/li"));
        Assert.assertTrue( webElementList.size() == 1 );
        oneResult = webElementList.get(0);
        Assert.assertEquals(oneResult.getText(),PORT_ROYAL_QUERY);
        searchInput.clear();
    }

}
