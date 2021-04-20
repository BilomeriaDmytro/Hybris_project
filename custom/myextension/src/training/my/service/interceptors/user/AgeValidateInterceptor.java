package training.my.service.interceptors.user;

import de.hybris.platform.core.model.user.UserModel;
import de.hybris.platform.servicelayer.interceptor.InterceptorContext;
import de.hybris.platform.servicelayer.interceptor.InterceptorException;
import de.hybris.platform.servicelayer.interceptor.ValidateInterceptor;

public class AgeValidateInterceptor implements ValidateInterceptor<UserModel> {

    @Override
    public void onValidate(UserModel userModel, InterceptorContext interceptorContext)
            throws InterceptorException {

        if(userModel.getAge() != null && userModel.getAge() < 0){
            throw new InterceptorException("Age of user with name - " + userModel.getName() + " is below 0.");
        }
    }
}
