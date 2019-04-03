/**
 * @license Copyright (c) 2003-2018, CKSource - Frederico Knabben. All rights reserved.
 * For licensing, see https://ckeditor.com/legal/ckeditor-oss-license
 */

CKEDITOR.editorConfig = function( config ) {
	// Define changes to default configuration here. For example:
	// config.language = 'fr';
	// config.uiColor = '#AADC6E';

    config.filebrowserUploadUrl = '/newsUpload?type=File';
    config.filebrowserImageUploadUrl = "/newsUpload/newsImg?type=image&CKEditor=editor1&CKEditorFuncNum=1&langCode=zh-cn";
    config.filebrowserFlashUploadUrl = '/newsUpload?type=Flash';
};
