package training.my.service.impl;

import de.hybris.platform.tx.Transaction;
import groovy.lang.GroovyShell;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;
import training.my.service.TransactionService;
import javax.annotation.Resource;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class DefaultTransactionService implements TransactionService {

    @Resource
    private PlatformTransactionManager txManager;

    final private String scriptMostOrdersPath = "C:\\Users\\Dmitriy\\hybris-commerce\\hybris\\bin\\custom\\myextension\\resources\\scripts\\scriptMostOrders.groovy";
    final private String scriptLastOrderPath = "C:\\Users\\Dmitriy\\hybris-commerce\\hybris\\bin\\custom\\myextension\\resources\\scripts\\scriptLastOrder.groovy";

    @Override
    public void callScriptsWithTemplate(){

        final TransactionTemplate template = new TransactionTemplate(txManager);
        template.execute(new TransactionCallbackWithoutResult() {

            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                final GroovyShell shell = new GroovyShell();
                try {
                    shell.evaluate(new FileReader(scriptMostOrdersPath));
                    shell.evaluate(new FileReader(scriptLastOrderPath));

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public void callScriptsWithAPI() {

        final Transaction transaction = Transaction.current();
        boolean success = false;
        transaction.begin();

        final GroovyShell shell = new GroovyShell();
        try {
            shell.evaluate(new FileReader(scriptMostOrdersPath));
            shell.evaluate(new FileReader(scriptLastOrderPath));
            success = true;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if(success){
                transaction.commit();
            } else {
                transaction.rollback();
            }
        }
    }
}