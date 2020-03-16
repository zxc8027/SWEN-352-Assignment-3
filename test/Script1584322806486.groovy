import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser('')

WebUI.navigateToUrl('https://www.apple.com')

WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Apple/a_iPhone'), 1)

WebUI.click(findTestObject('Object Repository/Page_Apple/a_iPhone'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Page_iPhone/a_iPhone11_ProNew'), 1)

WebUI.click(findTestObject('Object Repository/Page_iPhone/a_iPhone11_ProNew'))

WebUI.click(findTestObject('Object Repository/Page_iPhone11Pro/a_Buy'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Buy_iPhone11Pro/span_NoFrom 4162moper month or 999'), 
    1)

WebUI.click(findTestObject('Object Repository/Page_Buy_iPhone11Pro/span_NoFrom 4162moper month or 999'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Buy_iPhone11Pro/span_iPhone11Pro 58-inch dis_4ceba1'), 
    1)

WebUI.click(findTestObject('Object Repository/Page_Buy_iPhone11Pro/span_iPhone11Pro 58-inch dis_4ceba1'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Buy_iPhone11Pro/label_Space Gray'), 1)

WebUI.click(findTestObject('Object Repository/Page_Buy_iPhone11Pro/label_Space Gray'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Buy_iPhone11Pro/label_256GB2'), 1)

WebUI.click(findTestObject('Object Repository/Page_Buy_iPhone11Pro/label_256GB2'))

WebUI.waitForElementClickable(findTestObject('Page_Buy iPhone 11 Pro and iPhone 11 Pro Ma_60f3f1/h2_SIM-Free'), 1)

WebUI.click(findTestObject('Object Repository/Page_Buy iPhone 11 Pro and iPhone 11 Pro Ma_60f3f1/h2_SIM-Free'))

WebUI.waitForElementClickable(findTestObject('Page_iPhone 11 Pro 256GB Space Gray - Apple/button_NoAppleCare'), 1)

WebUI.click(findTestObject('Object Repository/Page_iPhone 11 Pro 256GB Space Gray - Apple/button_NoAppleCare'))

WebUI.waitForElementClickable(findTestObject('Page_iPhone 11 Pro 256GB Space Gray - Apple/span_Add to Bag'), 1)

WebUI.click(findTestObject('Object Repository/Page_iPhone 11 Pro 256GB Space Gray - Apple/span_Add to Bag'))

WebUI.closeBrowser()

