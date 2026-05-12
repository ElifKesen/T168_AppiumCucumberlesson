package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.KiwiPage;
import utilities.Driver;
import utilities.ResuableMethods;

public class KiwiStepDef {
    KiwiPage page=new KiwiPage();

    @Given("Continue as a guest butonuna tiklanir")
    public void continue_as_a_guest_butonuna_tiklanir() {
        page.continueAsButton.click();
    }

         // Feature'da yoruma aldigimiz step in kodlari
    @When("Acilan sayfalarda Continue ve Explore the app tiklanir")
    public void acilan_sayfalarda_continue_ve_explore_the_app_tiklanir() {
        for (int i = 0; i < 4; i++) {
            ResuableMethods.koordinatTiklamaMethodu(550,2050,500);
        }

    }
    @When("Acilan sayfalarda {string} ve {string}  tiklanir")
    public void acilanSayfalardaVeTiklanir(String Continue, String Exploretheapp) throws InterruptedException {
        Thread.sleep(3000);
        for (int i = 0; i < 3; i++) {
            ResuableMethods.scrollWithUiScrollableAndClick(Continue);
            Thread.sleep(3000);
        }
        Thread.sleep(3000);
        ResuableMethods.scrollWithUiScrollableAndClick(Exploretheapp);
    }


    @When("Trip type one way olarak secilir")
    public void trip_type_one_way_olarak_secilir() throws InterruptedException {
        Thread.sleep(4000);
        page.secimButton.click();
        Thread.sleep(3000);
        page.oneWayButton.click();


    }
    @When("Kalkıs sehri secenegine tiklanir ve default olan sehir kaldirilir")
    public void kalkıs_sehri_secenegine_tiklanir_ve_default_olan_sehir_kaldirilir() throws InterruptedException {
        Thread.sleep(3000);
        page.fromButton.click();
        page.clearButton.click();

    }
    @When("Kalkıs sehri alanina Ankara yazilir ve Choose butonuna tiklanir")
    public void kalkıs_sehri_alanina_ankara_yazilir_ve_choose_butonuna_tiklanir() throws InterruptedException {
        Thread.sleep(3000);
        page.kalkisVarisYeriYazmaKutusu.click();

        if (Driver.getAndroidDriver().isKeyboardShown()) {
            Driver.getAndroidDriver().getKeyboard().pressKey("Ankara");
        } else {
            page.kalkisVarisYeriYazmaKutusu.sendKeys("Ankara");
        }
        Thread.sleep(3000);
        page.sehirSecmeButonu.click();
        page.chooseButonu.click();

    }

    @When("Varış sehri alanina Frankfurt yazilir ve Choose butonuna tiklanir")
    public void varış_sehri_alanina_frankfurt_yazilir_ve_choose_butonuna_tiklanir() throws InterruptedException {
        page.toButonu.click();
        page.kalkisVarisYeriYazmaKutusu.click();
        Thread.sleep(3000);
        if (Driver.getAndroidDriver().isKeyboardShown()) {
            Driver.getAndroidDriver().getKeyboard().pressKey("Frankfurt");
        } else {
            page.kalkisVarisYeriYazmaKutusu.sendKeys("Frankfurt");
        }
        Thread.sleep(3000);
        page.sehirSecmeButonu.click();
        page.chooseButonu.click();
    }

    @When("Gidiş tarihi alanindan {int} Mayis secilir ve Set Date butonuna tiklanir")
    public void gidiş_tarihi_alanindan_mayis_secilir_ve_set_date_butonuna_tiklanir(Integer int1) throws InterruptedException {
        page.departureButonu.click();
        Thread.sleep(3000);
        ResuableMethods.koordinatTiklamaMethodu(392, 1245, 300);
        Thread.sleep(3000);
        page.setDatebutonu.click();

    }
    @When("Search butonuna tiklanir")
    public void search_butonuna_tiklanir() throws InterruptedException {
        Thread.sleep(3000);
        page.searchbutonu.click();


    }
    @When("En ucuz ve Aktarmasiz filtrelemeleri yapilir")
    public void en_ucuz_ve_aktarmasiz_filtrelemeleri_yapilir() {
        page.bestbutonu.click();
        page.enUcuzbutonu.click();
        page.Stopbutonu.click();
        page.nonStopbutonu.click();


    }
    @Then("Gelen ilk bilet fiyati kaydedilir ve kullanicinin telefonuna SMS olarak gonderilir")
    public void gelen_ilk_bilet_fiyati_kaydedilir_ve_kullanicinin_telefonuna_sms_olarak_gonderilir() {
        String fiyat = page.fiyatBilgisi.getText();
        Driver.getAndroidDriver().sendSMS("1111", "Bilet fiyat bilgisi: " + fiyat);

    }


}
