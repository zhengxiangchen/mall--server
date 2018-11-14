(function ($, undefined) {

    $.util.namespace("$.easyui.icons");

    var iconData = [
        { iconCls: "icon-hamburg-address", cls: ".icon-hamburg-address", text: "icon-hamburg-address", path: "icon-hamburg/16x16/address.png" },
        { iconCls: "icon-hamburg-advertising", cls: ".icon-hamburg-advertising", text: "icon-hamburg-advertising", path: "icon-hamburg/16x16/advertising.png" },
        { iconCls: "icon-hamburg-archives", cls: ".icon-hamburg-archives", text: "icon-hamburg-archives", path: "icon-hamburg/16x16/archives.png" },
        { iconCls: "icon-hamburg-attibutes", cls: ".icon-hamburg-attibutes", text: "icon-hamburg-attibutes", path: "icon-hamburg/16x16/attibutes.png" },
        { iconCls: "icon-hamburg-bank", cls: ".icon-hamburg-bank", text: "icon-hamburg-bank", path: "icon-hamburg/16x16/bank.png" },
        { iconCls: "icon-hamburg-basket", cls: ".icon-hamburg-basket", text: "icon-hamburg-basket", path: "icon-hamburg/16x16/basket.png" },
        { iconCls: "icon-hamburg-bestseller", cls: ".icon-hamburg-bestseller", text: "icon-hamburg-bestseller", path: "icon-hamburg/16x16/bestseller.png" },
        { iconCls: "icon-hamburg-billing", cls: ".icon-hamburg-billing", text: "icon-hamburg-billing", path: "icon-hamburg/16x16/billing.png" },
        { iconCls: "icon-hamburg-bookmark", cls: ".icon-hamburg-bookmark", text: "icon-hamburg-bookmark", path: "icon-hamburg/16x16/bookmark.png" },
        { iconCls: "icon-hamburg-bug", cls: ".icon-hamburg-bug", text: "icon-hamburg-bug", path: "icon-hamburg/16x16/bug.png" },
        { iconCls: "icon-hamburg-business", cls: ".icon-hamburg-business", text: "icon-hamburg-business", path: "icon-hamburg/16x16/business.png" },
        { iconCls: "icon-hamburg-busy", cls: ".icon-hamburg-busy", text: "icon-hamburg-busy", path: "icon-hamburg/16x16/busy.png" },
        { iconCls: "icon-hamburg-calendar", cls: ".icon-hamburg-calendar", text: "icon-hamburg-calendar", path: "icon-hamburg/16x16/calendar.png" },
        { iconCls: "icon-hamburg-category", cls: ".icon-hamburg-category", text: "icon-hamburg-category", path: "icon-hamburg/16x16/category.png" },
        { iconCls: "icon-hamburg-check", cls: ".icon-hamburg-check", text: "icon-hamburg-check", path: "icon-hamburg/16x16/check.png" },
        { iconCls: "icon-hamburg-config", cls: ".icon-hamburg-config", text: "icon-hamburg-config", path: "icon-hamburg/16x16/config.png" },
        { iconCls: "icon-hamburg-consulting", cls: ".icon-hamburg-consulting", text: "icon-hamburg-consulting", path: "icon-hamburg/16x16/consulting.png" },
        { iconCls: "icon-hamburg-contact", cls: ".icon-hamburg-contact", text: "icon-hamburg-contact", path: "icon-hamburg/16x16/contact.png" },
        { iconCls: "icon-hamburg-cost", cls: ".icon-hamburg-cost", text: "icon-hamburg-cost", path: "icon-hamburg/16x16/cost.png" },
        { iconCls: "icon-hamburg-credit-card", cls: ".icon-hamburg-credit-card", text: "icon-hamburg-credit-card", path: "icon-hamburg/16x16/credit-card.png" },
        { iconCls: "icon-hamburg-credit", cls: ".icon-hamburg-credit", text: "icon-hamburg-credit", path: "icon-hamburg/16x16/credit.png" },
        { iconCls: "icon-hamburg-current-work", cls: ".icon-hamburg-current-work", text: "icon-hamburg-current-work", path: "icon-hamburg/16x16/current-work.png" },
        { iconCls: "icon-hamburg-customers", cls: ".icon-hamburg-customers", text: "icon-hamburg-customers", path: "icon-hamburg/16x16/customers.png" },
        { iconCls: "icon-hamburg-cv", cls: ".icon-hamburg-cv", text: "icon-hamburg-cv", path: "icon-hamburg/16x16/cv.png" },
        { iconCls: "icon-hamburg-database", cls: ".icon-hamburg-database", text: "icon-hamburg-database", path: "icon-hamburg/16x16/database.png" },
        { iconCls: "icon-hamburg-date", cls: ".icon-hamburg-date", text: "icon-hamburg-date", path: "icon-hamburg/16x16/date.png" },
        { iconCls: "icon-hamburg-delicious", cls: ".icon-hamburg-delicious", text: "icon-hamburg-delicious", path: "icon-hamburg/16x16/delicious.png" },
        { iconCls: "icon-hamburg-docs", cls: ".icon-hamburg-docs", text: "icon-hamburg-docs", path: "icon-hamburg/16x16/docs.png" },
        { iconCls: "icon-hamburg-document", cls: ".icon-hamburg-document", text: "icon-hamburg-document", path: "icon-hamburg/16x16/document.png" },
        { iconCls: "icon-hamburg-donate", cls: ".icon-hamburg-donate", text: "icon-hamburg-donate", path: "icon-hamburg/16x16/donate.png" },
        { iconCls: "icon-hamburg-down", cls: ".icon-hamburg-down", text: "icon-hamburg-down", path: "icon-hamburg/16x16/down.png" },
        { iconCls: "icon-hamburg-drawings", cls: ".icon-hamburg-drawings", text: "icon-hamburg-drawings", path: "icon-hamburg/16x16/drawings.png" },
        { iconCls: "icon-hamburg-email", cls: ".icon-hamburg-email", text: "icon-hamburg-email", path: "icon-hamburg/16x16/email.png" },
        { iconCls: "icon-hamburg-equalizer", cls: ".icon-hamburg-equalizer", text: "icon-hamburg-equalizer", path: "icon-hamburg/16x16/equalizer.png" },
        { iconCls: "icon-hamburg-exchange", cls: ".icon-hamburg-exchange", text: "icon-hamburg-exchange", path: "icon-hamburg/16x16/exchange.png" },
        { iconCls: "icon-hamburg-featured", cls: ".icon-hamburg-featured", text: "icon-hamburg-featured", path: "icon-hamburg/16x16/featured.png" },
        { iconCls: "icon-hamburg-feed", cls: ".icon-hamburg-feed", text: "icon-hamburg-feed", path: "icon-hamburg/16x16/feed.png" },
        { iconCls: "icon-hamburg-finished", cls: ".icon-hamburg-finished", text: "icon-hamburg-finished", path: "icon-hamburg/16x16/finished.png" },
        { iconCls: "icon-hamburg-flag", cls: ".icon-hamburg-flag", text: "icon-hamburg-flag", path: "icon-hamburg/16x16/flag.png" },
        { iconCls: "icon-hamburg-folder", cls: ".icon-hamburg-folder", text: "icon-hamburg-folder", path: "icon-hamburg/16x16/folder.png" },
        { iconCls: "icon-hamburg-for-job", cls: ".icon-hamburg-for-job", text: "icon-hamburg-for-job", path: "icon-hamburg/16x16/for-job.png" },
        { iconCls: "icon-hamburg-freelance", cls: ".icon-hamburg-freelance", text: "icon-hamburg-freelance", path: "icon-hamburg/16x16/freelance.png" },
        { iconCls: "icon-hamburg-full-time", cls: ".icon-hamburg-full-time", text: "icon-hamburg-full-time", path: "icon-hamburg/16x16/full-time.png" },
        { iconCls: "icon-hamburg-future", cls: ".icon-hamburg-future", text: "icon-hamburg-future", path: "icon-hamburg/16x16/future.png" },
        { iconCls: "icon-hamburg-graphic", cls: ".icon-hamburg-graphic", text: "icon-hamburg-graphic", path: "icon-hamburg/16x16/graphic.png" },
        { iconCls: "icon-hamburg-graphy", cls: ".icon-hamburg-graphy", text: "icon-hamburg-graphy", path: "icon-hamburg/16x16/graphy.png" },
        { iconCls: "icon-hamburg-heart", cls: ".icon-hamburg-heart", text: "icon-hamburg-heart", path: "icon-hamburg/16x16/heart.png" },
        { iconCls: "icon-hamburg-hire-me", cls: ".icon-hamburg-hire-me", text: "icon-hamburg-hire-me", path: "icon-hamburg/16x16/hire-me.png" },
        { iconCls: "icon-hamburg-home", cls: ".icon-hamburg-home", text: "icon-hamburg-home", path: "icon-hamburg/16x16/home.png" },
        { iconCls: "icon-hamburg-illustration", cls: ".icon-hamburg-illustration", text: "icon-hamburg-illustration", path: "icon-hamburg/16x16/illustration.png" },
        { iconCls: "icon-hamburg-invoice", cls: ".icon-hamburg-invoice", text: "icon-hamburg-invoice", path: "icon-hamburg/16x16/invoice.png" },
        { iconCls: "icon-hamburg-issue", cls: ".icon-hamburg-issue", text: "icon-hamburg-issue", path: "icon-hamburg/16x16/issue.png" },
        { iconCls: "icon-hamburg-left", cls: ".icon-hamburg-left", text: "icon-hamburg-left", path: "icon-hamburg/16x16/left.png" },
        { iconCls: "icon-hamburg-library", cls: ".icon-hamburg-library", text: "icon-hamburg-library", path: "icon-hamburg/16x16/library.png" },
        { iconCls: "icon-hamburg-lightbulb", cls: ".icon-hamburg-lightbulb", text: "icon-hamburg-lightbulb", path: "icon-hamburg/16x16/lightbulb.png" },
        { iconCls: "icon-hamburg-link", cls: ".icon-hamburg-link", text: "icon-hamburg-link", path: "icon-hamburg/16x16/link.png" },
        { iconCls: "icon-hamburg-lock", cls: ".icon-hamburg-lock", text: "icon-hamburg-lock", path: "icon-hamburg/16x16/lock.png" },
        { iconCls: "icon-hamburg-login", cls: ".icon-hamburg-login", text: "icon-hamburg-login", path: "icon-hamburg/16x16/login.png" },
        { iconCls: "icon-hamburg-logout", cls: ".icon-hamburg-logout", text: "icon-hamburg-logout", path: "icon-hamburg/16x16/logout.png" },
        { iconCls: "icon-hamburg-milestone", cls: ".icon-hamburg-milestone", text: "icon-hamburg-milestone", path: "icon-hamburg/16x16/milestone.png" },
        { iconCls: "icon-hamburg-monitor", cls: ".icon-hamburg-monitor", text: "icon-hamburg-monitor", path: "icon-hamburg/16x16/monitor.png" },
        { iconCls: "icon-hamburg-music", cls: ".icon-hamburg-music", text: "icon-hamburg-music", path: "icon-hamburg/16x16/music.png" },
        { iconCls: "icon-hamburg-my-account", cls: ".icon-hamburg-my-account", text: "icon-hamburg-my-account", path: "icon-hamburg/16x16/my-account.png" },
        { iconCls: "icon-hamburg-networking", cls: ".icon-hamburg-networking", text: "icon-hamburg-networking", path: "icon-hamburg/16x16/networking.png" },
        { iconCls: "icon-hamburg-old-versions", cls: ".icon-hamburg-old-versions", text: "icon-hamburg-old-versions", path: "icon-hamburg/16x16/old-versions.png" },
        { iconCls: "icon-hamburg-order", cls: ".icon-hamburg-order", text: "icon-hamburg-order", path: "icon-hamburg/16x16/order.png" },
        { iconCls: "icon-hamburg-payment-card", cls: ".icon-hamburg-payment-card", text: "icon-hamburg-payment-card", path: "icon-hamburg/16x16/payment-card.png" },
        { iconCls: "icon-hamburg-pencil", cls: ".icon-hamburg-pencil", text: "icon-hamburg-pencil", path: "icon-hamburg/16x16/pencil.png" },
        { iconCls: "icon-hamburg-phone", cls: ".icon-hamburg-phone", text: "icon-hamburg-phone", path: "icon-hamburg/16x16/phone.png" },
        { iconCls: "icon-hamburg-pictures", cls: ".icon-hamburg-pictures", text: "icon-hamburg-pictures", path: "icon-hamburg/16x16/pictures.png" },
        { iconCls: "icon-hamburg-premium", cls: ".icon-hamburg-premium", text: "icon-hamburg-premium", path: "icon-hamburg/16x16/premium.png" },
        { iconCls: "icon-hamburg-print", cls: ".icon-hamburg-print", text: "icon-hamburg-print", path: "icon-hamburg/16x16/print.png" },
        { iconCls: "icon-hamburg-process", cls: ".icon-hamburg-process", text: "icon-hamburg-process", path: "icon-hamburg/16x16/process.png" },
        { iconCls: "icon-hamburg-product-design", cls: ".icon-hamburg-product-design", text: "icon-hamburg-product-design", path: "icon-hamburg/16x16/product-design.png" },
        { iconCls: "icon-hamburg-product", cls: ".icon-hamburg-product", text: "icon-hamburg-product", path: "icon-hamburg/16x16/product.png" },
        { iconCls: "icon-hamburg-project", cls: ".icon-hamburg-project", text: "icon-hamburg-project", path: "icon-hamburg/16x16/project.png" },
        { iconCls: "icon-hamburg-publish", cls: ".icon-hamburg-publish", text: "icon-hamburg-publish", path: "icon-hamburg/16x16/publish.png" },
        { iconCls: "icon-hamburg-refresh", cls: ".icon-hamburg-refresh", text: "icon-hamburg-refresh", path: "icon-hamburg/16x16/refresh.png" },
        { iconCls: "icon-hamburg-right", cls: ".icon-hamburg-right", text: "icon-hamburg-right", path: "icon-hamburg/16x16/right.png" },
        { iconCls: "icon-hamburg-search", cls: ".icon-hamburg-search", text: "icon-hamburg-search", path: "icon-hamburg/16x16/search.png" },
        { iconCls: "icon-hamburg-settings", cls: ".icon-hamburg-settings", text: "icon-hamburg-settings", path: "icon-hamburg/16x16/settings.png" },
        { iconCls: "icon-hamburg-shipping", cls: ".icon-hamburg-shipping", text: "icon-hamburg-shipping", path: "icon-hamburg/16x16/shipping.png" },
        { iconCls: "icon-hamburg-showreel", cls: ".icon-hamburg-showreel", text: "icon-hamburg-showreel", path: "icon-hamburg/16x16/showreel.png" },
        { iconCls: "icon-hamburg-sign-in", cls: ".icon-hamburg-sign-in", text: "icon-hamburg-sign-in", path: "icon-hamburg/16x16/sign-in.png" },
        { iconCls: "icon-hamburg-sign-out", cls: ".icon-hamburg-sign-out", text: "icon-hamburg-sign-out", path: "icon-hamburg/16x16/sign-out.png" },
        { iconCls: "icon-hamburg-sign-up", cls: ".icon-hamburg-sign-up", text: "icon-hamburg-sign-up", path: "icon-hamburg/16x16/sign-up.png" },
        { iconCls: "icon-hamburg-sitemap", cls: ".icon-hamburg-sitemap", text: "icon-hamburg-sitemap", path: "icon-hamburg/16x16/sitemap.png" },
        { iconCls: "icon-hamburg-special", cls: ".icon-hamburg-special", text: "icon-hamburg-special", path: "icon-hamburg/16x16/special.png" },
        { iconCls: "icon-hamburg-star", cls: ".icon-hamburg-star", text: "icon-hamburg-star", path: "icon-hamburg/16x16/star.png" },
        { iconCls: "icon-hamburg-statistics", cls: ".icon-hamburg-statistics", text: "icon-hamburg-statistics", path: "icon-hamburg/16x16/statistics.png" },
        { iconCls: "icon-hamburg-stop", cls: ".icon-hamburg-stop", text: "icon-hamburg-stop", path: "icon-hamburg/16x16/stop.png" },
        { iconCls: "icon-hamburg-suppliers", cls: ".icon-hamburg-suppliers", text: "icon-hamburg-suppliers", path: "icon-hamburg/16x16/suppliers.png" },
        { iconCls: "icon-hamburg-tag", cls: ".icon-hamburg-tag", text: "icon-hamburg-tag", path: "icon-hamburg/16x16/tag.png" },
        { iconCls: "icon-hamburg-ticket", cls: ".icon-hamburg-ticket", text: "icon-hamburg-ticket", path: "icon-hamburg/16x16/ticket.png" },
        { iconCls: "icon-hamburg-trash", cls: ".icon-hamburg-trash", text: "icon-hamburg-trash", path: "icon-hamburg/16x16/trash.png" },
        { iconCls: "icon-hamburg-up", cls: ".icon-hamburg-up", text: "icon-hamburg-up", path: "icon-hamburg/16x16/up.png" },
        { iconCls: "icon-hamburg-user", cls: ".icon-hamburg-user", text: "icon-hamburg-user", path: "icon-hamburg/16x16/user.png" },
        { iconCls: "icon-hamburg-world", cls: ".icon-hamburg-world", text: "icon-hamburg-world", path: "icon-hamburg/16x16/world.png" },
        { iconCls: "icon-hamburg-zoom", cls: ".icon-hamburg-zoom", text: "icon-hamburg-zoom", path: "icon-hamburg/16x16/zoom.png" },


        { iconCls: "icon-hamburg-32-address", cls: ".icon-hamburg-32-address", text: "icon-hamburg-32-address", path: "icon-hamburg/32x32/address.png" },
        { iconCls: "icon-hamburg-32-administrative-docs", cls: ".icon-hamburg-32-administrative-docs", text: "icon-hamburg-32-administrative-docs", path: "icon-hamburg/32x32/administrative-docs.png" },
        { iconCls: "icon-hamburg-32-advertising", cls: ".icon-hamburg-32-advertising", text: "icon-hamburg-32-advertising", path: "icon-hamburg/32x32/advertising.png" },
        { iconCls: "icon-hamburg-32-archives", cls: ".icon-hamburg-32-archives", text: "icon-hamburg-32-archives", path: "icon-hamburg/32x32/archives.png" },
        { iconCls: "icon-hamburg-32-attibutes", cls: ".icon-hamburg-32-attibutes", text: "icon-hamburg-32-attibutes", path: "icon-hamburg/32x32/attibutes.png" },
        { iconCls: "icon-hamburg-32-bank", cls: ".icon-hamburg-32-bank", text: "icon-hamburg-32-bank", path: "icon-hamburg/32x32/bank.png" },
        { iconCls: "icon-hamburg-32-basket", cls: ".icon-hamburg-32-basket", text: "icon-hamburg-32-basket", path: "icon-hamburg/32x32/basket.png" },
        { iconCls: "icon-hamburg-32-bestseller", cls: ".icon-hamburg-32-bestseller", text: "icon-hamburg-32-bestseller", path: "icon-hamburg/32x32/bestseller.png" },
        { iconCls: "icon-hamburg-32-billing", cls: ".icon-hamburg-32-billing", text: "icon-hamburg-32-billing", path: "icon-hamburg/32x32/billing.png" },
        { iconCls: "icon-hamburg-32-bookmark", cls: ".icon-hamburg-32-bookmark", text: "icon-hamburg-32-bookmark", path: "icon-hamburg/32x32/bookmark.png" },
        { iconCls: "icon-hamburg-32-brainstorming", cls: ".icon-hamburg-32-brainstorming", text: "icon-hamburg-32-brainstorming", path: "icon-hamburg/32x32/brainstorming.png" },
        { iconCls: "icon-hamburg-32-business-contact", cls: ".icon-hamburg-32-business-contact", text: "icon-hamburg-32-business-contact", path: "icon-hamburg/32x32/business-contact.png" },
        { iconCls: "icon-hamburg-32-busy", cls: ".icon-hamburg-32-busy", text: "icon-hamburg-32-busy", path: "icon-hamburg/32x32/busy.png" },
        { iconCls: "icon-hamburg-32-calendar", cls: ".icon-hamburg-32-calendar", text: "icon-hamburg-32-calendar", path: "icon-hamburg/32x32/calendar.png" },
        { iconCls: "icon-hamburg-32-category", cls: ".icon-hamburg-32-category", text: "icon-hamburg-32-category", path: "icon-hamburg/32x32/category.png" },
        { iconCls: "icon-hamburg-32-check", cls: ".icon-hamburg-32-check", text: "icon-hamburg-32-check", path: "icon-hamburg/32x32/check.png" },
        { iconCls: "icon-hamburg-32-collaboration", cls: ".icon-hamburg-32-collaboration", text: "icon-hamburg-32-collaboration", path: "icon-hamburg/32x32/collaboration.png" },
        { iconCls: "icon-hamburg-32-comment", cls: ".icon-hamburg-32-comment", text: "icon-hamburg-32-comment", path: "icon-hamburg/32x32/comment.png" },
        { iconCls: "icon-hamburg-32-communication", cls: ".icon-hamburg-32-communication", text: "icon-hamburg-32-communication", path: "icon-hamburg/32x32/communication.png" },
        { iconCls: "icon-hamburg-32-config", cls: ".icon-hamburg-32-config", text: "icon-hamburg-32-config", path: "icon-hamburg/32x32/config.png" },
        { iconCls: "icon-hamburg-32-consulting", cls: ".icon-hamburg-32-consulting", text: "icon-hamburg-32-consulting", path: "icon-hamburg/32x32/consulting.png" },
        { iconCls: "icon-hamburg-32-contact", cls: ".icon-hamburg-32-contact", text: "icon-hamburg-32-contact", path: "icon-hamburg/32x32/contact.png" },
        { iconCls: "icon-hamburg-32-cost", cls: ".icon-hamburg-32-cost", text: "icon-hamburg-32-cost", path: "icon-hamburg/32x32/cost.png" },
        { iconCls: "icon-hamburg-32-credit-card", cls: ".icon-hamburg-32-credit-card", text: "icon-hamburg-32-credit-card", path: "icon-hamburg/32x32/credit-card.png" },
        { iconCls: "icon-hamburg-32-credit", cls: ".icon-hamburg-32-credit", text: "icon-hamburg-32-credit", path: "icon-hamburg/32x32/credit.png" },
        { iconCls: "icon-hamburg-32-current-work", cls: ".icon-hamburg-32-current-work", text: "icon-hamburg-32-current-work", path: "icon-hamburg/32x32/current-work.png" },
        { iconCls: "icon-hamburg-32-customers", cls: ".icon-hamburg-32-customers", text: "icon-hamburg-32-customers", path: "icon-hamburg/32x32/customers.png" },
        { iconCls: "icon-hamburg-32-cv", cls: ".icon-hamburg-32-cv", text: "icon-hamburg-32-cv", path: "icon-hamburg/32x32/cv.png" },
        { iconCls: "icon-hamburg-32-database", cls: ".icon-hamburg-32-database", text: "icon-hamburg-32-database", path: "icon-hamburg/32x32/database.png" },
        { iconCls: "icon-hamburg-32-date", cls: ".icon-hamburg-32-date", text: "icon-hamburg-32-date", path: "icon-hamburg/32x32/date.png" },
        { iconCls: "icon-hamburg-32-delicious", cls: ".icon-hamburg-32-delicious", text: "icon-hamburg-32-delicious", path: "icon-hamburg/32x32/delicious.png" },
        { iconCls: "icon-hamburg-32-document-library", cls: ".icon-hamburg-32-document-library", text: "icon-hamburg-32-document-library", path: "icon-hamburg/32x32/document-library.png" },
        { iconCls: "icon-hamburg-32-donate", cls: ".icon-hamburg-32-donate", text: "icon-hamburg-32-donate", path: "icon-hamburg/32x32/donate.png" },
        { iconCls: "icon-hamburg-32-drawings", cls: ".icon-hamburg-32-drawings", text: "icon-hamburg-32-drawings", path: "icon-hamburg/32x32/drawings.png" },
        { iconCls: "icon-hamburg-32-edit", cls: ".icon-hamburg-32-edit", text: "icon-hamburg-32-edit", path: "icon-hamburg/32x32/edit.png" },
        { iconCls: "icon-hamburg-32-email", cls: ".icon-hamburg-32-email", text: "icon-hamburg-32-email", path: "icon-hamburg/32x32/email.png" },
        { iconCls: "icon-hamburg-32-featured", cls: ".icon-hamburg-32-featured", text: "icon-hamburg-32-featured", path: "icon-hamburg/32x32/featured.png" },
        { iconCls: "icon-hamburg-32-feed", cls: ".icon-hamburg-32-feed", text: "icon-hamburg-32-feed", path: "icon-hamburg/32x32/feed.png" },
        { iconCls: "icon-hamburg-32-finished-work", cls: ".icon-hamburg-32-finished-work", text: "icon-hamburg-32-finished-work", path: "icon-hamburg/32x32/finished-work.png" },
        { iconCls: "icon-hamburg-32-flag", cls: ".icon-hamburg-32-flag", text: "icon-hamburg-32-flag", path: "icon-hamburg/32x32/flag.png" },
        { iconCls: "icon-hamburg-32-folder", cls: ".icon-hamburg-32-folder", text: "icon-hamburg-32-folder", path: "icon-hamburg/32x32/folder.png" },
        { iconCls: "icon-hamburg-32-free-for-job", cls: ".icon-hamburg-32-free-for-job", text: "icon-hamburg-32-free-for-job", path: "icon-hamburg/32x32/free-for-job.png" },
        { iconCls: "icon-hamburg-32-freelance", cls: ".icon-hamburg-32-freelance", text: "icon-hamburg-32-freelance", path: "icon-hamburg/32x32/freelance.png" },
        { iconCls: "icon-hamburg-32-full-time", cls: ".icon-hamburg-32-full-time", text: "icon-hamburg-32-full-time", path: "icon-hamburg/32x32/full-time.png" },
        { iconCls: "icon-hamburg-32-future-projects", cls: ".icon-hamburg-32-future-projects", text: "icon-hamburg-32-future-projects", path: "icon-hamburg/32x32/future-projects.png" },
        { iconCls: "icon-hamburg-32-graphic-design", cls: ".icon-hamburg-32-graphic-design", text: "icon-hamburg-32-graphic-design", path: "icon-hamburg/32x32/graphic-design.png" },
        { iconCls: "icon-hamburg-32-heart", cls: ".icon-hamburg-32-heart", text: "icon-hamburg-32-heart", path: "icon-hamburg/32x32/heart.png" },
        { iconCls: "icon-hamburg-32-hire-me", cls: ".icon-hamburg-32-hire-me", text: "icon-hamburg-32-hire-me", path: "icon-hamburg/32x32/hire-me.png" },
        { iconCls: "icon-hamburg-32-home", cls: ".icon-hamburg-32-home", text: "icon-hamburg-32-home", path: "icon-hamburg/32x32/home.png" },
        { iconCls: "icon-hamburg-32-illustration", cls: ".icon-hamburg-32-illustration", text: "icon-hamburg-32-illustration", path: "icon-hamburg/32x32/illustration.png" },
        { iconCls: "icon-hamburg-32-invoice", cls: ".icon-hamburg-32-invoice", text: "icon-hamburg-32-invoice", path: "icon-hamburg/32x32/invoice.png" },
        { iconCls: "icon-hamburg-32-issue", cls: ".icon-hamburg-32-issue", text: "icon-hamburg-32-issue", path: "icon-hamburg/32x32/issue.png" },
        { iconCls: "icon-hamburg-32-library", cls: ".icon-hamburg-32-library", text: "icon-hamburg-32-library", path: "icon-hamburg/32x32/library.png" },
        { iconCls: "icon-hamburg-32-lightbulb", cls: ".icon-hamburg-32-lightbulb", text: "icon-hamburg-32-lightbulb", path: "icon-hamburg/32x32/lightbulb.png" },
        { iconCls: "icon-hamburg-32-limited-edition", cls: ".icon-hamburg-32-limited-edition", text: "icon-hamburg-32-limited-edition", path: "icon-hamburg/32x32/limited-edition.png" },
        { iconCls: "icon-hamburg-32-link", cls: ".icon-hamburg-32-link", text: "icon-hamburg-32-link", path: "icon-hamburg/32x32/link.png" },
        { iconCls: "icon-hamburg-32-lock", cls: ".icon-hamburg-32-lock", text: "icon-hamburg-32-lock", path: "icon-hamburg/32x32/lock.png" },
        { iconCls: "icon-hamburg-32-login", cls: ".icon-hamburg-32-login", text: "icon-hamburg-32-login", path: "icon-hamburg/32x32/login.png" },
        { iconCls: "icon-hamburg-32-logout", cls: ".icon-hamburg-32-logout", text: "icon-hamburg-32-logout", path: "icon-hamburg/32x32/logout.png" },
        { iconCls: "icon-hamburg-32-milestone", cls: ".icon-hamburg-32-milestone", text: "icon-hamburg-32-milestone", path: "icon-hamburg/32x32/milestone.png" },
        { iconCls: "icon-hamburg-32-my-account", cls: ".icon-hamburg-32-my-account", text: "icon-hamburg-32-my-account", path: "icon-hamburg/32x32/my-account.png" },
        { iconCls: "icon-hamburg-32-networking", cls: ".icon-hamburg-32-networking", text: "icon-hamburg-32-networking", path: "icon-hamburg/32x32/networking.png" },
        { iconCls: "icon-hamburg-32-old-versions", cls: ".icon-hamburg-32-old-versions", text: "icon-hamburg-32-old-versions", path: "icon-hamburg/32x32/old-versions.png" },
        { iconCls: "icon-hamburg-32-order-1", cls: ".icon-hamburg-32-order-1", text: "icon-hamburg-32-order-1", path: "icon-hamburg/32x32/order-1.png" },
        { iconCls: "icon-hamburg-32-order", cls: ".icon-hamburg-32-order", text: "icon-hamburg-32-order", path: "icon-hamburg/32x32/order.png" },
        { iconCls: "icon-hamburg-32-payment-card", cls: ".icon-hamburg-32-payment-card", text: "icon-hamburg-32-payment-card", path: "icon-hamburg/32x32/payment-card.png" },
        { iconCls: "icon-hamburg-32-paypal", cls: ".icon-hamburg-32-paypal", text: "icon-hamburg-32-paypal", path: "icon-hamburg/32x32/paypal.png" },
        { iconCls: "icon-hamburg-32-pen", cls: ".icon-hamburg-32-pen", text: "icon-hamburg-32-pen", path: "icon-hamburg/32x32/pen.png" },
        { iconCls: "icon-hamburg-32-pencil", cls: ".icon-hamburg-32-pencil", text: "icon-hamburg-32-pencil", path: "icon-hamburg/32x32/pencil.png" },
        { iconCls: "icon-hamburg-32-phone", cls: ".icon-hamburg-32-phone", text: "icon-hamburg-32-phone", path: "icon-hamburg/32x32/phone.png" },
        { iconCls: "icon-hamburg-32-photography", cls: ".icon-hamburg-32-photography", text: "icon-hamburg-32-photography", path: "icon-hamburg/32x32/photography.png" },
        { iconCls: "icon-hamburg-32-plus", cls: ".icon-hamburg-32-plus", text: "icon-hamburg-32-plus", path: "icon-hamburg/32x32/plus.png" },
        { iconCls: "icon-hamburg-32-premium", cls: ".icon-hamburg-32-premium", text: "icon-hamburg-32-premium", path: "icon-hamburg/32x32/premium.png" },
        { iconCls: "icon-hamburg-32-print", cls: ".icon-hamburg-32-print", text: "icon-hamburg-32-print", path: "icon-hamburg/32x32/print.png" },
        { iconCls: "icon-hamburg-32-process", cls: ".icon-hamburg-32-process", text: "icon-hamburg-32-process", path: "icon-hamburg/32x32/process.png" },
        { iconCls: "icon-hamburg-32-product-1", cls: ".icon-hamburg-32-product-1", text: "icon-hamburg-32-product-1", path: "icon-hamburg/32x32/product-1.png" },
        { iconCls: "icon-hamburg-32-product-design", cls: ".icon-hamburg-32-product-design", text: "icon-hamburg-32-product-design", path: "icon-hamburg/32x32/product-design.png" },
        { iconCls: "icon-hamburg-32-product", cls: ".icon-hamburg-32-product", text: "icon-hamburg-32-product", path: "icon-hamburg/32x32/product.png" },
        { iconCls: "icon-hamburg-32-project", cls: ".icon-hamburg-32-project", text: "icon-hamburg-32-project", path: "icon-hamburg/32x32/project.png" },
        { iconCls: "icon-hamburg-32-publish", cls: ".icon-hamburg-32-publish", text: "icon-hamburg-32-publish", path: "icon-hamburg/32x32/publish.png" },
        { iconCls: "icon-hamburg-32-refresh", cls: ".icon-hamburg-32-refresh", text: "icon-hamburg-32-refresh", path: "icon-hamburg/32x32/refresh.png" },
        { iconCls: "icon-hamburg-32-search", cls: ".icon-hamburg-32-search", text: "icon-hamburg-32-search", path: "icon-hamburg/32x32/search.png" },
        { iconCls: "icon-hamburg-32-settings", cls: ".icon-hamburg-32-settings", text: "icon-hamburg-32-settings", path: "icon-hamburg/32x32/settings.png" },
        { iconCls: "icon-hamburg-32-shipping", cls: ".icon-hamburg-32-shipping", text: "icon-hamburg-32-shipping", path: "icon-hamburg/32x32/shipping.png" },
        { iconCls: "icon-hamburg-32-showreel", cls: ".icon-hamburg-32-showreel", text: "icon-hamburg-32-showreel", path: "icon-hamburg/32x32/showreel.png" },
        { iconCls: "icon-hamburg-32-sign-in", cls: ".icon-hamburg-32-sign-in", text: "icon-hamburg-32-sign-in", path: "icon-hamburg/32x32/sign-in.png" },
        { iconCls: "icon-hamburg-32-sign-out", cls: ".icon-hamburg-32-sign-out", text: "icon-hamburg-32-sign-out", path: "icon-hamburg/32x32/sign-out.png" },
        { iconCls: "icon-hamburg-32-sign-up", cls: ".icon-hamburg-32-sign-up", text: "icon-hamburg-32-sign-up", path: "icon-hamburg/32x32/sign-up.png" },
        { iconCls: "icon-hamburg-32-sitemap", cls: ".icon-hamburg-32-sitemap", text: "icon-hamburg-32-sitemap", path: "icon-hamburg/32x32/sitemap.png" },
        { iconCls: "icon-hamburg-32-special-offer", cls: ".icon-hamburg-32-special-offer", text: "icon-hamburg-32-special-offer", path: "icon-hamburg/32x32/special-offer.png" },
        { iconCls: "icon-hamburg-32-star", cls: ".icon-hamburg-32-star", text: "icon-hamburg-32-star", path: "icon-hamburg/32x32/star.png" },
        { iconCls: "icon-hamburg-32-statistics", cls: ".icon-hamburg-32-statistics", text: "icon-hamburg-32-statistics", path: "icon-hamburg/32x32/statistics.png" },
        { iconCls: "icon-hamburg-32-suppliers", cls: ".icon-hamburg-32-suppliers", text: "icon-hamburg-32-suppliers", path: "icon-hamburg/32x32/suppliers.png" },
        { iconCls: "icon-hamburg-32-tag", cls: ".icon-hamburg-32-tag", text: "icon-hamburg-32-tag", path: "icon-hamburg/32x32/tag.png" },
        { iconCls: "icon-hamburg-32-ticket", cls: ".icon-hamburg-32-ticket", text: "icon-hamburg-32-ticket", path: "icon-hamburg/32x32/ticket.png" },
        { iconCls: "icon-hamburg-32-twitter", cls: ".icon-hamburg-32-twitter", text: "icon-hamburg-32-twitter", path: "icon-hamburg/32x32/twitter.png" },
        { iconCls: "icon-hamburg-32-upcoming-work", cls: ".icon-hamburg-32-upcoming-work", text: "icon-hamburg-32-upcoming-work", path: "icon-hamburg/32x32/upcoming-work.png" },
        { iconCls: "icon-hamburg-32-user", cls: ".icon-hamburg-32-user", text: "icon-hamburg-32-user", path: "icon-hamburg/32x32/user.png" },
        { iconCls: "icon-hamburg-32-world", cls: ".icon-hamburg-32-world", text: "icon-hamburg-32-world", path: "icon-hamburg/32x32/world.png" },
        { iconCls: "icon-hamburg-32-zoom", cls: ".icon-hamburg-32-zoom", text: "icon-hamburg-32-zoom", path: "icon-hamburg/32x32/zoom.png" }
    ];

    $.easyui.icons.hamburg = iconData;

    var iconStyle = { name: "hamburg", size: "16,32" };
    if ($.isArray($.easyui.iconStyles)) { $.array.merge($.easyui.iconStyles, iconStyle); } else { $.easyui.iconStyles = [iconStyle]; }

})(jQuery);