<%-- 
    Document   : blog-admin
    Created on : Nov 5, 2015, 11:14:35 AM
    Author     : Suzanne Ludwig
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/blogstyles.css" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/jquery-ui.css" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/jquery-ui.structure.min.css" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/jquery-ui.theme.min.css" />

        <title>Dan's Dynamic Blog - Admin</title>
    </head>
    <body>
        <div id="header">
            <a href="${pageContext.request.contextPath}/home"><h1>Dan's Dynamic Blog</h1></a>
            <div id="getdown">
                <div class="dropdown">
                    <button class="btn btn-default custom-width dropdown-toggle" type="button" data-toggle="dropdown">Blogs
                        <span class="caret"></span></button>
                    <ul class="dropdown-menu dropdown-menu-right">
                        <li><a href="${pageContext.request.contextPath}/page-admin">Webpages</a></li>
                        <li><a href="${pageContext.request.contextPath}/announcement-admin">Announcements</a></li>
                    </ul>
                </div>
            </div>
            <a href="${pageContext.request.contextPath}/j_spring_security_logout"> <button id="logout-button" class='btn btn-default'>
                    Log Out
                </button></a>
        </div>


        <div class="container-replacer">

            <div class="col-md-3 grey" id="left-links">
                <div class="unpublished-blog-links" id="unapproved-blogs">
                    <h3>Unapproved Blogs</h3>

                </div>
                <div class="unpublished-blog-links" id="unpublished-blogs">
                    <h3>Unpublished Blogs</h3>

                </div>
            </div>
            <div class="col-md-offset-3 col-md-9 grey" id="editor-content">
                <div class="col-md-9">
                    <div style = "position: relative"> 
                        <div id="grey-box"
                             style = "z-index: 1;
                             position: absolute; 
                             background-color: grey; 
                             opacity: 0.8;
                             width: 100%;
                             height: 600px;
                             background: #ddd;
                             text-align: center;
                             padding-top: 200px;">
                            Click "Create" to make an entry <br>
                            Or select a blog to edit.
                        </div>
                        <textarea id="blog_entry" style = "position: absolute;
                                  width: 100%;
                                  height: 250px;">
                        </textarea>
                    </div>
                    <br>
                    <form class="form-horizontal" role="form">
                        <div class="form-group">
                            <label for="add-categories" class="control-label col-md-2">
                                Tags:
                            </label>
                            <div class="col-md-10">
                                <input type="text"
                                       class="form-control"
                                       id="add-categories"
                                       placeholder="Tags (comma-separated)" />
                            </div>
                        </div>
                        <div class="checkbox" >
                            <label><input type="checkbox" id="publish-date-checkbox"> <strong>Publish Date</strong></label>
                            <input type="text" class="datepicker" id="publish-date" disabled />
                        </div>
                        <div class="checkbox" >
                            <label><input type="checkbox" id="expiry-date-checkbox"> <strong>Expiry Date</strong></label>
                            <input type="text" class="datepicker" id="expiry-date" disabled />
                        </div>

                    </form>
                    <div id="editor-buttons">
                        <button id="submit-button" type="submit" class='btn btn-success'>Publish</button>
                        <button id="delete-button" class='btn btn-default'>Delete</button>
                        <button id="save-button" class='btn btn-default'>Save</button>
                        <input id="blogpost-id" type="text" style="display:none">
                    </div>
                </div>
                <div class="col-md-3">
                    <button id="create-button"
                            data-target="#create-modal"
                            data-toggle="modal"
                            class='btn btn-success'>Create</button>
                </div>
            </div>

        </div>

        <div class="modal fade" id="create-modal" tabindex="-1" role="dialog"
             aria-labelledby="pages-modal-label" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">
                            <span aria-hidden="true">&times;</span>
                            <span class="sr-only">Close</span>
                        </button>
                        <h4 class="modal-title" id="pages-modal-label">Create New Blog</h4>
                    </div>
                    <div class="modal-body">
                        <form class="form-horizontal" role="form">
                            <div class="form-group">
                                <label for="add-title" class="col-md-4 control-label">
                                    Title:
                                </label>
                                <div class="col-md-8">
                                    <input type="text"
                                           class="form-control"
                                           id="add-title"
                                           placeholder="Title" />
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-md-offset-4 col-md-8">
                                    <button type="submit"
                                            id="add-button"
                                            class="btn btn-default">
                                        Create Blog
                                    </button>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-md-offset-4 col-md-8">
                                    <button id="cancel-button"
                                            class="btn btn-default">
                                        Cancel
                                    </button>
                                </div>
                            </div>
                            
                        </form>

                    </div>

                </div>     
            </div>
        </div>
        <script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/jquery-ui.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/tinymce/tinymce.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/blogJS.js"></script>
        <script type="text/javascript">
            tinymce.init({
                selector: "#blog_entry"
            });
        </script>

    </body>

</html>
