$(function () {
    var formTemplate = $('#companyPosEditTemplate');
    
    $(document).on('click', '#companyPositionModal', function(e) {
        cleanAddNewCompanyPosForm(e, $(this));
    });
    
    function closeAllOpenedForms() {
        $('ul.companyPosItemsList').find('form').each(function() {
            $(this).closest('li.list-group-item').find('.companyPosItem').removeClass('hidden');
            $(this).remove();
        });
    }
    
    function stopCompanyPositionEdition(event, element) {
        var listItem = $(element).closest('li.list-group-item');
        listItem.find('form').remove();
        listItem.find('.companyPosItem').removeClass('hidden');
    }
    
    function cleanAddNewCompanyPosForm(event, element) {
        $(element).find('.companyPosButtonsNew').addClass('hidden');
        $(element).find('.companyPosInputNew').val('');
    }
    
    $(document).on('click', '.companyPosLabel', function(event) {
        closeAllOpenedForms();
        
        var listItem = $(this).closest('li.list-group-item');
        var companyPosItem = listItem.find('.companyPosItem');
        var label = $(this).html();
        var id = listItem.data('positionId');
        var form = formTemplate.find('form').clone();
        form.find('input[name=position_id]').val(id);
        form.find('input[name=position_label]').val(label);
        companyPosItem.addClass('hidden');
        listItem.append(form).find('input[name=position_label]').focus();
    });
    
    function saveEditedCompanyPos(event, element) {
        var listItem = $(element).parents('li.list-group-item');
        var btn = $(listItem).find('.companyPosEditSaveBtn');
        var cancelBtn = $(listItem).find('.companyPosEditCancelBtn');
        var inputField = $(listItem).find('.companyPosInput');
        var value = inputField.val();
        if (value) {
            cancelBtn.addClass('hidden');
            btn.button('loading');
            
            // todo: replace with AJAX
            setTimeout(function(){
                listItem.html(
                    '<div class="companyPosItem">' +
                        '<span class="companyPosLabel">' + value + '</span>' +
            			'<ul class="list-group-submenu">' +
        					'<li class="list-group-submenu-item">' +
                                '<button type="button" class="btn btn-default no-border" data-toggle="tooltip" data-placement="top" title="Remove">' +
                                    '<span class="glyphicon glyphicon-remove"></span>' +
                                '</button>' +
                            '</li>' +
    					'</ul>' +
                    '</div>'
                );
            }, 1500);
        }
    }
    
    $(document).on('click', '.companyPosEditSaveBtn', function (e) {
        console.log('clicked');
        e.stopPropagation();
        saveEditedCompanyPos(e, $(this));
    });
    
    $(document).on('keypress', '.companyPosInput', function (e) {
        if (e.which === 13) {
            e.stopPropagation();
            e.preventDefault();
            saveEditedCompanyPos(e, $(this));
        }
    });
    
    $(document).on('click', '.companyPosEditCancelBtn', function(e) {
        stopCompanyPositionEdition(e, $(this));
    });
    
    $(document).on('click', '.companyPosEditCancelBtn', stopCompanyPositionEdition);
    
    $(document).on('focus', '.companyPosInputNew', function() {
        var buttonsBar = $(this).parents('div').find('.companyPosButtonsNew');
        buttonsBar.removeClass('hidden');
    });
    
    $(document).on('click', '.companyPosCancelBtn', function (e) {
        cleanAddNewCompanyPosForm(e, $(this));
    });
    
    function saveNewCompanyPos(event, btn, inputField) {
        var cancelBtn = $('.companyPosCancelBtn');
        var listContainer = $('ul.companyPosItemsList');
        var value = inputField.val();
        
        if (value) {
            cancelBtn.addClass('hidden');
            btn.button('loading');
//        $.ajax(...).always(function () {
//        });
            // todo: replace with AJAX
            setTimeout(function(){
                listContainer.append(
                    '<li class="list-group-item"  data-position-id="231">' +
                        '<div class="companyPosItem">' +
                            '<span class="companyPosLabel">' + value + '</span>' +
            				'<ul class="list-group-submenu">' +
            					'<li class="list-group-submenu-item">' +
                                    '<button type="button" class="btn btn-default no-border" data-toggle="tooltip" data-placement="top" title="Remove">' +
                                        '<span class="glyphicon glyphicon-remove"></span>' +
                                    '</button>' +
                                '</li>' +
        					'</ul>' +
                        '</div>' +
    				'</li>'
                );
                inputField.val('');
                btn.button('reset');
                cancelBtn.removeClass('hidden');
            }, 1500);
        }
    }
    
    $(document).on('click', '.companyPosSaveBtn', function (e) {
        e.stopPropagation();
        var btn = $(this);
        var inputField = btn.parents('div').find('.companyPosInputNew');
        saveNewCompanyPos(e, btn, inputField);
    });
    
    $(document).on('keypress', '.companyPosInputNew', function (e) {
        if (e.which === 13) {
            e.stopPropagation();
            var inputField = $(this);
            var btn = inputField.parents('div').find('.companyPosSaveBtn');
            saveNewCompanyPos(e, btn, inputField);
        }
    });
});