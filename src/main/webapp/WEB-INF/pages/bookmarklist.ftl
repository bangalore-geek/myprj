<#import "/spring.ftl" as spring />
<#import "macro.ftl" as macro/>

<@macro.showHeader />
<div class="header">
    <h1 class="page-title">My Bookmark</h1>
</div>
<div ng-controller="BookmarkListCtrl">

<accordion close-others="oneAtATime">
    <accordion-group heading="{{x.title}}" ng-repeat="x in list" is-open="status.isFirstOpen" is-disabled="status.isFirstDisabled">
      {{x.desc}}
    </accordion-group>
</accordion>

</div>

<@macro.showFooter>
<script type="text/javascript" src="${rc.getContextPath()}/resources/js/pages/bookmarklist.js"></script>
</@macro.showFooter>