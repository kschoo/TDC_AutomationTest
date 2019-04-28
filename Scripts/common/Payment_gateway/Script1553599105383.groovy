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

WebUI.waitForElementClickable(findTestObject('pay_gateway/img_Pay securely using SSL by clicking on the card logo below_MasterCard'),
	20)

WebUI.click(findTestObject('pay_gateway/img_Pay securely using SSL by clicking on the card logo below_MasterCard'))

WebUI.setText(findTestObject('pay_gateway/input_Card Number_cardno'), '5123450000000008')

WebUI.setText(findTestObject('pay_gateway/input_monthyear_cardexpirymonth'), '07')

WebUI.setText(findTestObject('pay_gateway/input_monthyear_cardexpiryyear'), '21')

WebUI.setText(findTestObject('pay_gateway/input_The 3 digits after the card number on the signature panel of your card._cardsecurecode'),
	'100')

WebUI.delay(5)

WebUI.click(findTestObject('pay_gateway/input_payButtonImage'))