  <style type="text/css">
    .first {
        color: #ccc;
        font-style: italic;
    }
    .second {
        color: #fff;
        font-weight: bold;
    }
</style>
<nav class="navbar navbar-inverse">
      <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
          <button data-target="#bs-example-navbar-collapse-9" data-toggle="collapse" class="navbar-toggle collapsed" type="button">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a href="#" class="navbar-brand"><span class="first">Bookmark</span> <span class="second">Manager</span></a>
        </div>
	</div><!-- /.container-fluid -->
 </nav>
<div class="sidebar-nav">
        <form class="search form-inline">
            <input type="text" placeholder="Search...">
        </form>

        <a data-toggle="collapse" class="nav-header collapsed" href="#dashboard-menu"><i class="icon-dashboard"></i>Dashboard</a>
        <ul class="nav nav-list collapse" id="dashboard-menu" style="height: 0px;">
            <li><a href="${rc.getContextPath()}/index">Home</a></li>
            <li><a href="${rc.getContextPath()}/bookmark">My Bookmark</a></li>
        </ul>

        <a data-toggle="collapse" class="nav-header" href="#accounts-menu"><i class="icon-briefcase"></i>Settings</a>
        <ul class="nav nav-list collapse" id="accounts-menu">
            <li><a href="${rc.getContextPath()}/settings">Application Setting</a></li>
            <li><a href="${rc.getContextPath()}/import">Import Bookmark</a></li>
            <li><a href="${rc.getContextPath()}/export">Export Bookark</a></li>
            <li><a href="${rc.getContextPath()}/cleanup">Perform Cleanup</a></li>
        </ul>

        <a data-toggle="collapse" class="nav-header collapsed" href="#error-menu"><i class="icon-exclamation-sign"></i>Account Option</a>
        <ul class="nav nav-list collapse" id="error-menu">
            <li><a href="${rc.getContextPath()}/manage-account">Manage Your Account</a></li>
            <li><a href="${rc.getContextPath()}/changepassword">Change Password</a></li>
            <li><a href="${rc.getContextPath()}/privacy">Privacy Setting</a></li>
            <li><a href="${rc.getContextPath()}/deleteaccount">Delete Account</a></li>
        </ul>
</div>