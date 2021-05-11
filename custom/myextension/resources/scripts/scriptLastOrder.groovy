package scripts;

import de.hybris.platform.core.Registry
import training.my.service.MyOrderService

myOrderService = Registry.getApplicationContext().getBean("myOrderService", MyOrderService);
System.out.println("Last order made by - " + myOrderService.lastOrder.getUser().getDisplayName())