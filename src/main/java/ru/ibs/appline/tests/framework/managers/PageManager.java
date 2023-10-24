package ru.ibs.appline.tests.framework.managers;

import ru.ibs.appline.tests.framework.pages.AuthPage;
import ru.ibs.appline.tests.framework.pages.BasePage;
import ru.ibs.appline.tests.framework.pages.QuickLaunchBarPage;

public class PageManager {

    private static PageManager INSTANCE = null;

    /**
     * Страница авторизации
     */
    private AuthPage authPage;

    /**
     * Панель быстрого запуска
     */

    private QuickLaunchBarPage quickLaunchBarPage;


    private PageManager() {
    }
    public static PageManager getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new PageManager ();
        }
        return INSTANCE;
    }

    public AuthPage getAuthPage() {
        if (authPage == null) {
            authPage = new AuthPage();
        }
        return authPage;
    }

    public QuickLaunchBarPage getQuickLaunchBarPage() {
        if (quickLaunchBarPage == null) {
            quickLaunchBarPage = new QuickLaunchBarPage();
        }
        return quickLaunchBarPage;
    }



}
