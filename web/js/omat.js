/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



  // oikeasti välitys
  
  $(document).ready(function(){
     $('.open-muokkaaModal').bind('click', function(){
          var id = $(this).attr('data-id');
          
          
          var nimi = $(this).attr('data-nimi');
          var hinta = $(this).attr('data-hinta');
          var osoite = $(this).attr('data-osoite');
          var maxVaraukset = $(this).attr('data-maxVaraukset');
          
          $('#id-kentta').val(id);
          $('#id-kentta2').val(id);
          $('#nimiKentta').val(nimi);
          $('#hintaKentta').val(hinta);
          $('#osoiteKentta').val(osoite);
          $('#maxVarauksetKentta').val(maxVaraukset);
     });
  });
  
  // poista modal
  
$(document).ready(function(){
     $('.open-poistaModal').bind('click', function(){
          var id = $('#id-kentta').attr('value');
          var nimi = $('#hidNimiKentta').attr('value');              
          
          $('#poistaID').val(id);
          $('#poistaNimi').val(nimi);

     });
  }); 
  
  $(document).ready(function(){
     $('.open-varaaModal').bind('click', function(){
          var id = $(this).attr('data-id');
          var nimi = $(this).attr('data-nimi');
          var url = $(this).attr('data-url');
                             
          $('#id-kentta').val(id);
          $('#id-kentta2').val(id);
          $('#lahja-nimi-hidden').val(nimi);
          $('#lahja-url-hidden').val(url);

     });
  });
  
  $(document).ready(function(){
     $('.open-muokkaaVarausModal').bind('click', function(){
          var lahjaId = $(this).attr('data-lId');
          var lahjaNimi = $(this).attr('data-lNimi');
          var varausId = $(this).attr('data-vId');
          var varausNimi = $(this).attr('data-vNimi');
                             
          $('#lId-kentta').val(lahjaId);
          $('#lId-kentta2').val(lahjaId);
          $('#vId-kentta').val(varausId);
          $('#vId-kentta2').val(varausId);
          $('#lNimi-kentta').val(lahjaNimi);
          $('#vNimi-kentta').val(varausNimi);

     });
  });
  

