package scripts;

import de.hybris.platform.core.Registry
import training.my.service.MyOrderService

myOrderService = Registry.getApplicationContext().getBean("myOrderService", MyOrderService);
System.out.println("User with most orders - " + myOrderService.userWithMostOrders.getDisplayName())