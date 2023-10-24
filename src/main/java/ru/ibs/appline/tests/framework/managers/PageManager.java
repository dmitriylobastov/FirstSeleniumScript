package ru.ibs.appline.tests.framework.managers;

import ru.ibs.appline.tests.framework.pages.AuthStartPage;
import ru.ibs.appline.tests.framework.pages.BusinessTripPage;
import ru.ibs.appline.tests.framework.pages.QuickLaunchBarPage;

public class PageManager {

    private static PageManager INSTANCE = null;

    /**
     * Страница авторизации
     */
    private AuthStartPage authPage;

    /**
     * Панель быстрого запуска
     */

    private QuickLaunchBarPage quickLaunchBarPage;

    private BusinessTripPage businessTripPage;


    private PageManager() {
    }
    public static PageManager getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new PageManager ();
        }
        return INSTANCE;
    }

    public AuthStartPage getAuthStartPage() {
        if (authPage == null) {
            authPage = new AuthStartPage();
        }
        return authPage;
    }

    public QuickLaunchBarPage getQuickLaunchBarPage() {
        if (quickLaunchBarPage == null) {
            quickLaunchBarPage = new QuickLaunchBarPage();
        }
        return quickLaunchBarPage;
    }

    public BusinessTripPage getBusinessTripPage() {
        if (businessTripPage == null) {
            businessTripPage = new BusinessTripPage();
        }
        return businessTripPage;
    }




}
