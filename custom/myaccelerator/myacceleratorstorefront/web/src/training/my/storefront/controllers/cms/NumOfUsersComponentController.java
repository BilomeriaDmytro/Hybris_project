package training.my.storefront.controllers.cms;

import de.hybris.platform.acceleratorstorefrontcommons.controllers.cms.AbstractCMSComponentController;
import org.apache.commons.lang.StringUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import training.my.core.model.NumOfUsersCMSComponentModel;
import training.my.storefront.controllers.ControllerConstants;
import javax.servlet.http.HttpServletRequest;

@Controller("NumOfUsersCMSComponentController")
@Scope("tenant")
@RequestMapping(value = ControllerConstants.Actions.Cms.NumOfUsersComponent)
public class NumOfUsersComponentController extends AbstractCMSComponentController<NumOfUsersCMSComponentModel> {

    @Override
    protected void fillModel(final HttpServletRequest request, final Model model, final NumOfUsersCMSComponentModel component) {

        //TODO extract num of users from service
        component.setContent("Users: 41");
        model.addAttribute("content",component.getContent());
    }

    @Override
    protected String getView(final NumOfUsersCMSComponentModel component) {
        return ControllerConstants.Views.Cms.ComponentPrefix + StringUtils.lowerCase(getTypeCode(component));
    }
}