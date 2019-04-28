import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

/**
 *  define a FTTO packages list 'FTTO_list', put package of 50mbps(FTTO_338) and 100mbps(FTTO_398) into the list.
 *  Loop thru the list, create order for all packages.
 */

FTTO_238 = 'http://10.60.70.16/onlinesubscribe_shaffiq/index.php/home/package/31'
FTTO_338 = 'http://10.60.70.16/onlinesubscribe_shaffiq/index.php/home/package/29'
FTTO_398 = 'http://10.60.70.16/onlinesubscribe_shaffiq/index.php/home/package/30'
def FTTO_list = [FTTO_238, FTTO_338, FTTO_398]

def lTestScenario = null

for (def pack : FTTO_list){

		WebUI.openBrowser('')
		
		WebUI.navigateToUrl(pack)
		
		// Identify test scenario
		if (pack == FTTO_238){
			lTestScenario = 'OLS_FTTO_238'
		} else if (pack == FTTO_338){
			lTestScenario = 'OLS_FTTO_338'
		} else if (pack == FTTO_398){
		    lTestScenario = 'OLS_FTTO_398'
		}
	
		// Begin -Have we got you covered
		WebUI.setText(findTestObject('OLS/FTTO/input_Have we got you covered_rfs'), findTestData('DataSource').getValue(2, 4))
		
		WebUI.click(findTestObject('OLS/FTTO/li_building_name'))
		
		WebUI.setText(findTestObject('OLS/FTTO/input_Block'), 'Z')
		
		WebUI.setText(findTestObject('OLS/FTTO/input_Level'), '200')
		
		WebUI.setText(findTestObject('OLS/FTTO/input_Unit'), findTestData('DataSource').getValue(3, 4))
		
		// Print page - 'Have_we_got_you_covered'
		lpagename = 'Have_we_got_you_covered'
		
		WebUI.callTestCase ( findTestCase('common/Take_Screenshot'), [('pTestScenario') : lTestScenario, ('pPageName') : lpagename],FailureHandling.STOP_ON_FAILURE)
		
		WebUI.click(findTestObject('OLS/FTTO/button_next'))
		// End -Have we got you covered
		
		//Begin - Personal details
		WebUI.selectOptionByValue(findTestObject('OLS/FTTO/select_Company_type'), '1', true)
		
		WebUI.setText(findTestObject('OLS/FTTO/input_No of Employees'), '20')
		
		WebUI.setText(findTestObject('OLS/FTTO/input_Company Name'), findTestData('DataSource').getValue(4, 4))
		
		WebUI.selectOptionByValue(findTestObject('OLS/FTTO/select_Industry_type'), '4', true)
		
		WebUI.click(findTestObject('OLS/FTTO/div_Business Registration Number'))
		
		WebUI.setText(findTestObject('OLS/FTTO/input_Business Registration Number'), 'T123456')
		
		WebUI.setText(findTestObject('OLS/FTTO/input_Full Name'), findTestData('DataSource').getValue(4, 4))
		
		WebUI.selectOptionByValue(findTestObject('OLS/FTTO/select_Gender'), 'male', true)
		
		WebUI.setText(findTestObject('OLS/FTTO/input_MyKad Number_ic1'), findTestData('DataSource').getValue(5, 4))
		
		WebUI.setText(findTestObject('OLS/FTTO/input_-_ic2'), findTestData('DataSource').getValue(6, 4))
		
		WebUI.setText(findTestObject('OLS/FTTO/input_-_ic3'), findTestData('DataSource').getValue(7, 4))
		
		WebUI.setText(findTestObject('OLS/FTTO/input_-_phone'), '1234567')
		
		WebUI.setText(findTestObject('OLS/FTTO/input_Email'), 'kee.suan.choo@time.com.my')
		
		WebUI.click(findTestObject('OLS/FTTO/label_1'))
		
		WebUI.click(findTestObject('OLS/FTTO/label_2'))
		
		WebUI.click(findTestObject('OLS/FTTO/label_3'))
		
		// Print Page - 'Personal_details'
		lpagename = 'Personal_details'
		
		WebUI.callTestCase ( findTestCase('common/Take_Screenshot'), [('pTestScenario') : lTestScenario, ('pPageName') : lpagename],FailureHandling.STOP_ON_FAILURE)
		
		WebUI.click(findTestObject('OLS/FTTO/button_next'))
		
		WebUI.click(findTestObject('OLS/FTTO/label_copy_billing_address'))
		
		WebUI.click(findTestObject('OLS/FTTO/button_Select File'))
		
		WebUI.callTestCase(findTestCase('common/Upload_documents'), [:], FailureHandling.STOP_ON_FAILURE)
		
		WebUI.click(findTestObject('OLS/FTTO/button_Select File_1'))
		
		WebUI.callTestCase(findTestCase('common/Upload_documents'), [:], FailureHandling.STOP_ON_FAILURE)
		
		WebUI.click(findTestObject('OLS/FTTO/button_Select File_2'))
		
		WebUI.callTestCase(findTestCase('common/Upload_documents'), [:], FailureHandling.STOP_ON_FAILURE)
		
		// Print Page - 'Billing_address'
		lpagename = 'Billing_address'
		
		WebUI.callTestCase ( findTestCase('common/Take_Screenshot'), [('pTestScenario') : lTestScenario, ('pPageName') : lpagename],FailureHandling.STOP_ON_FAILURE)
		
		
		WebUI.click(findTestObject('OLS/FTTO/button_preview'))
		//End - Company Info
		
		// Begin - preview
		
		// Print Page - 'Preview'
		lpagename = 'Preview'
		
		WebUI.callTestCase ( findTestCase('common/Take_Screenshot'), [('pTestScenario') : lTestScenario, ('pPageName') : lpagename],FailureHandling.STOP_ON_FAILURE)
		
		
		WebUI.click(findTestObject('OLS/FTTO/button_next_1'))
		// End - preview
		
		// Print Page - Confirm_payment
		lpagename = 'Confirm_payment'
		
		WebUI.callTestCase ( findTestCase('common/Take_Screenshot'), [('pTestScenario') : lTestScenario, ('pPageName') : lpagename],FailureHandling.STOP_ON_FAILURE)
		
		WebUI.click(findTestObject('OLS/FTTO/button_confirm'))
		
		WebUI.callTestCase(findTestCase('common/Payment_gateway'), [:], FailureHandling.STOP_ON_FAILURE)
		
		WebUI.callTestCase(findTestCase('common/ACS_Emulator'), [:], FailureHandling.STOP_ON_FAILURE)
		
		WebUI.delay(10)
		
		//Begin Apppoinment calender
		thisDay = findTestData('DataSource').getValue(9, 4)
		
		calenderDay = ('CALENDER/a_' + thisDay)
		
		WebUI.waitForElementClickable(findTestObject(calenderDay), 8)
		
		// if date is not avilable, select next month
		if (WebUI.waitForElementClickable(findTestObject(calenderDay), 8) == false) {
		    WebUI.selectOptionByIndex(findTestObject('OLS/CALENDER/select_Month'), 1)
		}
		
		WebUI.waitForElementClickable(findTestObject(calenderDay), 13)
		
		WebUI.scrollToElement(findTestObject(calenderDay), 0)
		
		WebUI.mouseOver(findTestObject(calenderDay))
		
		WebUI.doubleClick(findTestObject(calenderDay))
		
		WebUI.delay(10)
		
		WebUI.selectOptionByIndex(findTestObject('OLS/FTTO/select_Please select sessionMorning (1000AM)Afternoon (230PM)'), 1)
		
		// Print Page - 'Calender'
		lpagename = 'Calender'
		
		WebUI.callTestCase ( findTestCase('common/Take_Screenshot'), [('pTestScenario') : lTestScenario, ('pPageName') : lpagename],FailureHandling.STOP_ON_FAILURE)
		
		
		WebUI.click(findTestObject('OLS/FTTO/button_proceed'))
		
		//End Apppoinment calender
		WebUI.click(findTestObject('OLS/FTTO/button_Yes'))
		
		WebUI.closeBrowser()

}
