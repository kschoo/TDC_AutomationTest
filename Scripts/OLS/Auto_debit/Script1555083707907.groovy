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

WebUI.click(findTestObject('OLS/FTTH/label_This is the same as the service installation address.'))

//WebUI.setText(findTestObject('OLS/FTTH/input_Name on Card_cc_name'), findTestData('DataSource').getValue(4, 1))
WebUI.setText(findTestObject('OLS/FTTH/input_Name on Card_cc_name'), 'TEST CREDIT CARD')

WebUI.setText(findTestObject('OLS/FTTH/input_Card Number_cc_no'), '5123 4500 0000 0008')

WebUI.setText(findTestObject('OLS/FTTH/input_Card CVV_cc_cvc'), '100')

WebUI.selectOptionByValue(findTestObject('OLS/FTTH/select_JanuaryFebruaryMarchAprilMayJuneJulyAugustSeptemberOctoberNovemberDecember'),
	'7', true)

WebUI.selectOptionByValue(findTestObject('OLS/FTTH/select_2019202020212022202320242025202620272028202920302031203220332034'),
	'2021', true)