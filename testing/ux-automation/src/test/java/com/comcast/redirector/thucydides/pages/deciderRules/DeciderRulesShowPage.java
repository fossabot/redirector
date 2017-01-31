/**
 * Copyright 2016 Comcast Cable Communications Management, LLC 
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at 
 * http://www.apache.org/licenses/LICENSE-2.0 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */
package com.comcast.redirector.thucydides.pages.deciderRules;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.WebElementFacade;

@DefaultUrl("/showDeciderRules")
public class DeciderRulesShowPage extends PageObject {

    @FindBy(id = "toast-container")
    private WebElementFacade toaster;

    @FindBy(id = "dRDDMenu")
    private WebElementFacade dropdownMenu;

    @FindBy(id = "exportAll")
    private WebElementFacade exportAll;

    public void clickEditDeciderRulesButton(String value) {
        final String selector = "#editRule_" + value;
        waitForPresenceOf(selector);
        $(selector).click();
    }

    public void clickDeleteDeciderRulesButton(String value) {
        final String selector = "#deleteRule_" + value;
        waitForPresenceOf(selector);
        $(selector).click();
    }

    public void verifySuccessToasterIsShown() {
        toaster.waitUntilVisible();
        toaster.shouldContainText("Success");
    }

    public void clickExportDeciderRule(String value) {
        final String selector = "#exportRule_" + value;
        waitForPresenceOf(selector);
        $(selector).click();
    }

    public void clickExportAllDeciderRules() {
        dropdownMenu.click();
        waitABit(100);
        exportAll.click();
    }

}