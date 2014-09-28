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
          console.log('klikattu');
     });
  });
  
  // poista modal
  
$(document).ready(function(){
     $('.open-poistaModal').bind('click', function(){
          var id = $('#id-kentta').attr('value');
          var nimi = $('#hidNimiKentta').attr('value');
                    
          
          $('#poistaID').val(id);
          $('#poistaNimi').val(nimi);

          console.log('poistaKlikattu');
     });
  }); 
  
  $(document).ready(function(){
     $('.open-varaaModal').bind('click', function(){
          var id = $(this).attr('data-id');
          var nimi = $(this).attr('data-nimi');
          var url = $(this).attr('data-url');
                             
          $('#lahja-id-hidden').val(id);
          $('#lahja-nimi-hidden').val(nimi);
          $('#lahja-url-hidden').val(url);

          console.log('poistaKlikattu');
     });
  });
  
  $(document).ready(function(){
     $('.open-varanneetDropdown').bind('click', function(){
          var id = $(this).attr('data-id');
          var nimi = $(this).attr('data-nimi');
          var url = $(this).attr('data-url');
                             
          $('#lahja-id-hidden').val(id);
          $('#lahja-nimi-hidden').val(nimi);
          $('#lahja-url-hidden').val(url);

          console.log('poistaKlikattu');
     });
  });

