package training.my.storefront.controllers.cms;

import de.hybris.platform.acceleratorstorefrontcommons.controllers.cms.AbstractCMSComponentController;
import org.apache.commons.lang.StringUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import training.my.core.model.NumOfOrdersCMSComponentModel;
import training.my.service.MyOrderService;
import training.my.storefront.controllers.ControllerConstants;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller("NumOfOrdersCMSComponentController")
@Scope("tenant")
@RequestMapping(value = ControllerConstants.Actions.Cms.NumOfOrdersComponent)
public class NumOfOrdersComponentController extends AbstractCMSComponentController<NumOfOrdersCMSComponentModel> {

    @Resource
    private MyOrderService myOrderService;

    @Override
    protected void fillModel(final HttpServletRequest request, final Model model,
                             final NumOfOrdersCMSComponentModel component) {

        int orders = myOrderService.getTotalNumberOrders();
        component.setContent("Orders: " + orders);
        model.addAttribute("content",component.getContent());
    }

    @Override
    protected String getView(final NumOfOrdersCMSComponentModel component) {
        return ControllerConstants.Views.Cms.ComponentPrefix + StringUtils.lowerCase(getTypeCode(component));
    }
}