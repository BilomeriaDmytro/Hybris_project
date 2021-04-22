package training.my.repository;

import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;
import de.hybris.platform.servicelayer.search.SearchResult;
import java.util.Collections;
import java.util.List;

public class UserRepository {

    private FlexibleSearchService flexibleSearchService;

    public void setFlexibleSearchService(final FlexibleSearchService flexibleSearchService){
        this.flexibleSearchService = flexibleSearchService;
    }

    public int findTotalNumber(){

        String query = "Select count(1) from {User}";
        FlexibleSearchQuery flexibleSearchQuery = new FlexibleSearchQuery(query);
        flexibleSearchQuery.setResultClassList(Collections.singletonList(Integer.class));
        SearchResult<Integer> queryResult = flexibleSearchService.search(flexibleSearchQuery);
        List<Integer> integers = queryResult.getResult();

        return integers.get(0);
    }
}